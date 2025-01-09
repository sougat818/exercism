# Introduction

This file contains a checklist of steps to update the codebase. There are global and language specific steps.

## Exercism

- [ ] Upgrade Exercism version in [.gitpod.dockerfile](.gitpod.dockerfile) from [Exercism releases page](https://github.com/exercism/cli/releases)
- [ ] Check for updates to [.gitignore](.gitignore)

## Java

- [ ] Update exercism exercises
  - [ ] `for d in java/*/ ; do (cd "$d" && dir_name="${d#java/}"; exercism download --exercise="${dir_name%/}" --track=java); done`
- [ ] Update spotbugs versions in
  - [ ] [java/gradle.properties](java/gradle.properties) from <https://github.com/spotbugs/spotbugs-gradle-plugin#spotbugs-version-mapping>
- [ ] Update Java version in
  - [ ] [.github/workflows/java.yml](.github/workflows/java.yml)
  - [ ] [.sdkmanrc](.sdkmanrc)
