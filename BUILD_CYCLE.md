# SkStorage Build Cycle

How to build, version, strip comments, and cut a release.


# 1. strip comments from any Java files edited (see "Comment removal")
python tools/strip_comments.py src/main/java/.../ChangedFile.java

# 2. set version.properties so the build lands on target (see "Versioning")

# 3. commit + push code
git add -A
git commit -m "1.0.X: <summary>"
git push origin main

# 4. tag it. the tag is what triggers the release build
git tag v1.0.X
git push origin v1.0.X

Pushing a v*  tag fires .github/workflows/release.yml, which builds the jar
and publishes a GitHub Release with the jar attached.

## Requirements

- **JDK 17** to build. The Gradle plugin crashes on JDK 25 with a bogus
  IllegalArgumentException: 25.0.3. If the default java is newer, pass JDK 17
  explicitly:

JAVA_HOME="C:/Program Files/Eclipse Adoptium/jdk-17.0.16.8-hotspot" ./gradlew.bat build --no-daemon

CI runs on JDK 21, which is fine (21 < 25).

## Building

### Full build (produces the jar) — AUTO-INCREMENTS the version

./gradlew.bat build --no-daemon

Jar lands in build/libs/SkStorage-PUBLIC_x.z.y.jar.
This runs incrementBuild, which bumps version.properties by one.

### Build WITHOUT incrementing the version

incrementBuild is a dependency of processResources and shadowJar. Exclude it
with Gradle's -x flag:

./gradlew.bat build -x incrementBuild --no-daemon

Use this for test builds where you want a specific version stamped and NOT bumped
(e.g. building a 1.0.0 test jar to verify the OTA update checker fires).

### Compile only (no jar, never increments)

./gradlew.bat compileJava --no-daemon

Fastest way to check that code compiles. incrementBuild only hangs off the jar
tasks, so this never touches the version.

---

## Versioning

Version lives in version.properties:

build.x=1
build.z=0
build.y=1

Displayed as x.z.y with a phase prefix from phaseFor() in build.gradle.kts:

| x*100 + z*10 + y | phase   |
|------------------|---------|
| >= 100           | PUBLIC  |
| >= 10            | BETA    |
| < 10             | ALPHA   |

incrementBuild bumps y by one on every full build (rolls y>9 into z,
z>9 into x). So the file always sits ONE BEHIND the version the next build
will produce.

### To make the next build produce a specific version

Set version.properties to one less than the target y, because the build
increments before stamping:

- Want the next build to be PUBLIC_1.0.3 → set build.y=2
- Want the next build to be PUBLIC_1.0.1 → set build.y=0
- Want a PUBLIC_1.0.0 test jar → set build.y=-1 (the increment lands it on 0)

> A negative build.y is a legitimate one-shot trick for hitting x.z.0. The
> build rewrites the file to the real value afterward, so it doesn't stay negative.

### Keep the tag and the jar version in sync

The git tag (v1.0.3) names the RELEASE. The jar version comes from
version.properties. They are independent — if they drift, the release title and
the jar filename disagree. Before tagging, make sure version.properties will
stamp the jar to match the tag you're about to push.

---

## Comment removal

Public jars ship comment-free (config files keep their comments).

python tools/strip_comments.py <file1.java> <file2.java> ...

### Find which files still have comments

grep -rlE '//|/\*|^\s*\*' --include=*.java src/main/java

### Verify a strip didn't break URLs / left nothing behind

grep -nE 'https://' src/main/java/.../UpdateChecker.java   # URLs intact?
grep -rnE '//|/\*|^\s*\*' --include=*.java src/main/java | grep -vE 'https?://'

Then always confirm it still compiles:

./gradlew.bat compileJava --no-daemon

## Releasing (GitHub Actions)

.github/workflows/release.yml triggers on:
- push of a v* tag → builds AND publishes a Release with the jar attached
- manual dispatch** (gh workflow run release.yml --ref main) → builds and
  uploads the jar as an artifact only (does NOT create a Release)

Use manual dispatch to confirm CI is green before tagging a real release:

gh workflow run release.yml --ref main
gh run watch <run-id> --exit-status

Then tag + push to publish:

git tag v1.0.3
git push origin v1.0.3
gh release view v1.0.3 --json tagName,assets --jq '{tag:.tagName, assets:[.assets[].name]}'
