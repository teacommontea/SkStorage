param([switch]$Apply, [switch]$Reseed)

$ErrorActionPreference = "Stop"

$repo   = Split-Path $PSCommandPath -Parent | Split-Path -Parent
$root   = "$repo\SkStorage\src\main\java"
$tpl    = "$repo\tools\SKSTORAGEHEADER.txt"

$marker = "SkStorage - PLEASE READ BEFORE CONTINUING"

$tplText = [System.IO.File]::ReadAllText($tpl)
$tplText = $tplText.TrimStart([char]0xFEFF)
$closeIdx = $tplText.IndexOf("*/")
if ($closeIdx -lt 0) { Write-Error "template has no closing */"; exit 1 }
$banner = $tplText.Substring(0, $closeIdx + 2).TrimEnd()

$files = Get-ChildItem $root -Recurse -Filter *.java -ErrorAction SilentlyContinue |
    Where-Object { $_.FullName -notmatch "\\teacommontea\\skstorage\\docs\\" }

$injected = 0
$skipped  = 0
$reseeded = 0

foreach ($f in $files) {
    $text = Get-Content -Raw -Encoding utf8 $f.FullName

    if ($Reseed -and $text.Contains($marker)) {
        $mIdx = $text.IndexOf($marker)
        $startIdx = $text.LastIndexOf("/*", $mIdx)
        if ($startIdx -lt 0) { $startIdx = 0 }
        $endIdx = $text.IndexOf("*/", $mIdx)
        if ($endIdx -ge 0) {
            $after = $text.Substring($endIdx + 2).TrimStart("`r", "`n")
            $new = $banner + "`r`n`r`n" + $after
            if ($Apply -and $new -ne $text) {
                $utf8NoBom = New-Object System.Text.UTF8Encoding($false)
                [System.IO.File]::WriteAllText($f.FullName, $new, $utf8NoBom)
            }
            if ($new -ne $text) { $reseeded++ }
            continue
        }
    }

    $lines = [System.Collections.Generic.List[string]]($text -split "`r?`n")

    $hasHeader   = $text.Contains($marker)
    $hasReviewed = $text -match "@Reviewed\s*\("
    $hasImport   = $text -match "(?m)^\s*import\s+net\.teacommontea\.skstorage\.docs\.Reviewed\s*;"

    if ($hasHeader -and $hasReviewed) { $skipped++; continue }

    $pkgIdx = ($lines | Select-String -Pattern "^\s*package\s" | Select-Object -First 1).LineNumber
    if (-not $pkgIdx) { Write-Warning "no package in $($f.Name), skipping"; $skipped++; continue }
    $pkgIdx = $pkgIdx - 1

    $typeIdx = -1
    for ($k = 0; $k -lt $lines.Count; $k++) {
        if ($lines[$k] -match "^\s*(public\s+|final\s+|abstract\s+|sealed\s+|non-sealed\s+)*(class|interface|enum|record|@interface)\s") {
            $typeIdx = $k
            break
        }
    }
    if ($typeIdx -lt 0) { Write-Warning "no type decl in $($f.Name), skipping"; $skipped++; continue }

    if (-not $hasReviewed) {
        $indent = ""
        if ($lines[$typeIdx] -match "^(\s*)") { $indent = $matches[1] }
        $lines.Insert($typeIdx, "$indent@Reviewed(false)")
        if ($typeIdx -le $pkgIdx) { $pkgIdx++ }
    }

    if (-not $hasImport) {
        $lastImport = -1
        for ($k = 0; $k -lt $lines.Count; $k++) {
            if ($lines[$k] -match "^\s*import\s") { $lastImport = $k }
        }
        $insertAt = if ($lastImport -ge 0) { $lastImport + 1 } else { $pkgIdx + 1 }
        $lines.Insert($insertAt, "import net.teacommontea.skstorage.docs.Reviewed;")
    }

    if (-not $hasHeader) {
        $lines.Insert(0, "")
        for ($b = ($banner -split "`r?`n").Length - 1; $b -ge 0; $b--) {
            $lines.Insert(0, ($banner -split "`r?`n")[$b])
        }
    }

    $out = ($lines -join "`r`n")
    if ($Apply) {
        $utf8NoBom = New-Object System.Text.UTF8Encoding($false)
        [System.IO.File]::WriteAllText($f.FullName, $out, $utf8NoBom)
    }
    $injected++
}

$label = if ($Apply) { "APPLIED" } else { "DRY-RUN" }
Write-Output "${label}: $injected files need injection, $reseeded reseeded, $skipped already complete or skipped"
