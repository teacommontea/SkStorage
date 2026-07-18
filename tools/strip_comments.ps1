param([switch]$Apply)

$ErrorActionPreference = "Stop"

$repo  = Split-Path $PSCommandPath -Parent | Split-Path -Parent
$javac = (Get-Command javac -ErrorAction Stop).Source
$java  = (Get-Command java  -ErrorAction Stop).Source
$src   = "$PSScriptRoot\StripComments.java"

$out = "$repo\.buildlibs\_strip"
if (Test-Path $out) { Remove-Item -Recurse -Force $out }
New-Item -ItemType Directory -Force $out | Out-Null

& $javac -d $out $src
if ($LASTEXITCODE -ne 0) { exit 1 }

Push-Location $repo
try {
    if ($Apply) {
        & $java -cp $out StripComments --apply
    } else {
        & $java -cp $out StripComments
    }
} finally {
    Pop-Location
}
