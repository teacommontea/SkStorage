$ErrorActionPreference = 'Stop'

$repo = Split-Path $PSCommandPath -Parent | Split-Path -Parent
$dest = Join-Path $repo '.buildlibs'
New-Item -ItemType Directory -Force $dest | Out-Null

$central = 'https://repo1.maven.org/maven2'
$papermc = 'https://repo.papermc.io/repository/maven-public'
$jitpack = 'https://jitpack.io'

$deps = @(
    @{ repo=$papermc; group='io/papermc/paper';                  name='paper-api';                       ver='1.20.4-R0.1-SNAPSHOT'; file='paper-api-1.20.4-R0.1-SNAPSHOT.jar'; snapshot=$true },
    @{ repo=$jitpack; group='com/github/SkriptLang';             name='Skript';                          ver='2.9.3';                file='Skript-2.9.3.jar' },
    @{ repo=$central; group='org/xerial';                        name='sqlite-jdbc';                     ver='3.46.1.3';             file='sqlite-jdbc-3.46.1.3.jar' },
    @{ repo=$central; group='org/jetbrains';                     name='annotations';                     ver='24.1.0';               file='annotations-24.1.0.jar' },
    @{ repo=$central; group='com/google/guava';                  name='guava';                           ver='33.3.1-jre';           file='guava-33.3.1-jre.jar' },
    @{ repo=$central; group='org/checkerframework';              name='checker-qual';                    ver='4.2.0';                file='checker-qual-4.2.0.jar' },
    @{ repo=$central; group='com/google/inject';                 name='guice';                           ver='7.0.0';                file='guice-7.0.0.jar' },
    @{ repo=$papermc; group='net/md-5';                          name='bungeecord-chat';                 ver='1.16-R0.4-deprecated+build.6'; file='bungeecord-chat-1.16-R0.4-deprecated+build.6.jar' },
    @{ repo=$central; group='net/kyori';                         name='adventure-api';                   ver='4.16.0';               file='adventure-api-4.16.0.jar' },
    @{ repo=$central; group='net/kyori';                         name='adventure-key';                   ver='4.16.0';               file='adventure-key-4.16.0.jar' },
    @{ repo=$central; group='net/kyori';                         name='adventure-text-minimessage';      ver='4.16.0';               file='adventure-text-minimessage-4.16.0.jar' },
    @{ repo=$central; group='net/kyori';                         name='adventure-text-serializer-gson';  ver='4.16.0';               file='adventure-text-serializer-gson-4.16.0.jar' },
    @{ repo=$central; group='net/kyori';                         name='examination-api';                 ver='1.3.0';                file='examination-api-1.3.0.jar' },
    @{ repo=$central; group='net/kyori';                         name='examination-string';              ver='1.3.0';                file='examination-string-1.3.0.jar' },
    @{ repo=$central; group='com/intellectualsites/plotsquared'; name='plotsquared-core';                ver='7.3.8';                file='plotsquared-core-7.3.8.jar' },
    @{ repo=$central; group='com/intellectualsites/plotsquared'; name='plotsquared-bukkit';              ver='7.3.8';                file='plotsquared-bukkit-7.3.8.jar' }
)

$got = 0; $have = 0
foreach ($d in $deps) {
    $out = Join-Path $dest $d.file
    if (Test-Path $out) { $have++; continue }
    if ($d.snapshot) {
        $meta = "$($d.repo)/$($d.group)/$($d.name)/$($d.ver)/maven-metadata.xml"
        $xml = (Invoke-WebRequest -Uri $meta -UseBasicParsing).Content
        $ts  = [regex]::Match($xml, '<timestamp>([^<]+)</timestamp>').Groups[1].Value
        $bn  = [regex]::Match($xml, '<buildNumber>([^<]+)</buildNumber>').Groups[1].Value
        $base = $d.ver -replace '-SNAPSHOT$',''
        $real = "$($d.name)-$base-$ts-$bn.jar"
        $url  = "$($d.repo)/$($d.group)/$($d.name)/$($d.ver)/$real"
    } else {
        $url = "$($d.repo)/$($d.group)/$($d.name)/$($d.ver)/$($d.file)"
    }
    Write-Host "fetching $($d.file)"
    Invoke-WebRequest -Uri $url -OutFile $out -UseBasicParsing
    $got++
}
Write-Host "deps: $got downloaded, $have already present ($($deps.Count) total)" -ForegroundColor Green
