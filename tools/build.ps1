param(
    [switch]$NoBump
)

$ErrorActionPreference = 'Stop'

$repo = Split-Path $PSCommandPath -Parent | Split-Path -Parent
$proj = Join-Path $repo 'SkStorage'

$javac = (Get-Command javac -ErrorAction Stop).Source
$jar   = (Get-Command jar   -ErrorAction Stop).Source

$propsFile = Join-Path $proj 'version.properties'
$props = Get-Content $propsFile
$x = [int](($props | Where-Object { $_ -match '^build\.x=' }) -replace 'build\.x=','')
$z = [int](($props | Where-Object { $_ -match '^build\.z=' }) -replace 'build\.z=','')
$y = [int](($props | Where-Object { $_ -match '^build\.y=' }) -replace 'build\.y=','')

if (-not $NoBump) {
    $y += 1
    if ($y -gt 9) { $y = 0; $z += 1 }
    if ($z -gt 9) { $z = 0; $x += 1 }
    $utf8NoBom = New-Object System.Text.UTF8Encoding($false)
    [System.IO.File]::WriteAllText($propsFile, "build.x=$x`nbuild.z=$z`nbuild.y=$y`n", $utf8NoBom)
}

$n = $x * 100 + $z * 10 + $y
$phase = if ($n -ge 100) { 'PUBLIC' } elseif ($n -ge 10) { 'BETA' } else { 'ALPHA' }
$version = "${phase}_$x.$z.$y"
Write-Host "SkStorage version: $version" -ForegroundColor Cyan

$root = Join-Path $proj 'src\main\java'
$marker = "SkStorage - PLEASE READ BEFORE CONTINUING"

function Run-Review {
    $files = Get-ChildItem $root -Recurse -Filter *.java -ErrorAction SilentlyContinue |
        Where-Object { $_.FullName -notmatch "\\teacommontea\\skstorage\\docs\\" }

    $errors = [System.Collections.Generic.List[string]]::new()
    $warns  = [System.Collections.Generic.List[string]]::new()

    foreach ($f in $files) {
        $text = Get-Content -Raw -Encoding utf8 $f.FullName
        $rel = $f.Name
        if ($text.Contains($marker)) {
            $close = $text.IndexOf("*/")
            if ($close -ge 0) { $text = $text.Substring($close + 2) }
        }
        $m = [regex]::Match($text, '@Reviewed\s*\(\s*(true|false)\s*\)')
        if (-not $m.Success) { $errors.Add("ERROR: $rel is missing @Reviewed"); continue }
        if ($m.Groups[1].Value -eq 'false') { $warns.Add("WARN: $rel is unreviewed"); continue }
        if ($text -notmatch '@Description\s*\(') {
            $errors.Add("ERROR: $rel is @Reviewed(true) but has no @Description")
        }
    }

    $lines = [System.Collections.Generic.List[string]]::new()
    foreach ($w in $warns) { $lines.Add($w) }
    $code = 0
    if ($errors.Count -gt 0) {
        foreach ($e in $errors) { $lines.Add($e) }
        $lines.Add("--- review gate FAILED: $($errors.Count) error(s), $($warns.Count) warning(s) ---")
        $code = 1
    } else {
        $lines.Add("--- review gate passed: $($warns.Count) warning(s) ---")
    }
    $script:ReviewLines = $lines
    return $code
}

& (Join-Path $PSScriptRoot 'insert_header.ps1') -Apply | Out-Null
$rc = Run-Review
$script:ReviewLines | ForEach-Object { Write-Output $_ }
if ($rc -ne 0) { Write-Output "REVIEW GATE FAILED. Jar not built."; exit 1 }

$buildLibs = (Get-ChildItem (Join-Path $repo '.buildlibs') -Filter *.jar -ErrorAction SilentlyContinue |
        ForEach-Object { $_.FullName })
if (-not $buildLibs) {
    throw "No dependency jars in .buildlibs. Populate it before building."
}

$work = Join-Path $repo '.buildlibs\_build'
if (Test-Path $work) { Remove-Item -Recurse -Force $work }
New-Item -ItemType Directory -Force $work | Out-Null

$stubOut = Join-Path $work 'stub'
New-Item -ItemType Directory -Force $stubOut | Out-Null
$stubSrc = Get-ChildItem (Join-Path $proj 'litebans-api\src') -Recurse -Filter *.java | ForEach-Object { $_.FullName }
& $javac --release 17 -d $stubOut $stubSrc
if ($LASTEXITCODE -ne 0) { Write-Output "litebans stub compile failed."; exit 1 }

$cp = (@($stubOut) + $buildLibs) -join ';'
$out = Join-Path $work 'out'
New-Item -ItemType Directory -Force $out | Out-Null
$src = Get-ChildItem $root -Recurse -Filter *.java | ForEach-Object { $_.FullName }
Write-Host "Compiling $($src.Count) source files (javac --release 17)..." -ForegroundColor Cyan

$prev = $ErrorActionPreference; $ErrorActionPreference = 'Continue'
$res = & $javac --release 17 -encoding UTF-8 -cp $cp -d $out $src 2>&1
$ErrorActionPreference = $prev
$diags = $res | ForEach-Object { "$_" } | Where-Object { $_.Trim() -ne '' }
$errs = ($diags | Where-Object { $_ -match ': error:' }).Count
$warnCount = ($diags | Where-Object { $_ -match ': warning:' }).Count
if ($diags) { $diags | ForEach-Object { Write-Host $_ } }
Write-Host "--- diagnostics: $errs error(s), $warnCount warning(s) ---" -ForegroundColor Yellow
if ($errs -gt 0) { Write-Host "COMPILE FAILED." -ForegroundColor Red; exit 1 }

$stage = Join-Path $work 'stage'
New-Item -ItemType Directory -Force $stage | Out-Null
Copy-Item -Recurse (Join-Path $out '*') $stage
$resSrc = Join-Path $proj 'src\main\resources'
Get-ChildItem $resSrc -Recurse -File | ForEach-Object {
    $rel = $_.FullName.Substring($resSrc.Length + 1)
    $dest = Join-Path $stage $rel
    New-Item -ItemType Directory -Force (Split-Path $dest) | Out-Null
    if ($_.Name -eq 'plugin.yml') {
        $yml = (Get-Content $_.FullName -Raw).Replace('${version}', $version)
        [System.IO.File]::WriteAllText($dest, $yml, (New-Object System.Text.UTF8Encoding $false))
    } else {
        Copy-Item $_.FullName $dest
    }
}

Get-ChildItem $repo -Filter 'SkStorage-*.jar' -ErrorAction SilentlyContinue | ForEach-Object {
    git -C $repo rm -q --cached --ignore-unmatch $_.Name 2>$null
    Remove-Item -Force $_.FullName -ErrorAction SilentlyContinue
}
$target = Join-Path $repo "SkStorage-$version.jar"
& $jar --create --file $target -C $stage .
git -C $repo add "SkStorage-$version.jar" 2>$null

$classes = (Get-ChildItem $out -Recurse -Filter *.class -ErrorAction SilentlyContinue | Measure-Object).Count
Remove-Item -Recurse -Force $work -ErrorAction SilentlyContinue

$size = [math]::Round((Get-Item $target).Length / 1KB, 1)
Write-Host "BUILT  SkStorage-$version.jar  ($size KB, $classes classes)" -ForegroundColor Green
