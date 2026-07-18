$ErrorActionPreference = "Stop"

$repo  = Split-Path $PSCommandPath -Parent | Split-Path -Parent
$javac = (Get-Command javac -ErrorAction Stop).Source
$java  = (Get-Command java  -ErrorAction Stop).Source
$src   = "$PSScriptRoot\DocGrabber.java"

$out = "$repo\.buildlibs\_docs"
if (Test-Path $out) { Remove-Item -Recurse -Force $out }
New-Item -ItemType Directory -Force $out | Out-Null

& $javac -d $out $src
if ($LASTEXITCODE -ne 0) { exit 1 }

Push-Location $repo
try {
    & $java -cp $out DocGrabber
} finally {
    Pop-Location
}
