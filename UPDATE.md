This file contains a checklist of steps to update the codebase. There are global and language specific steps.

## Exercism

- [ ] Upgrade Exercism version in [.gitpod.dockerfile](.gitpod.dockerfile) from [Exercism releases page](https://github.com/exercism/cli/releases)
- [ ] Check for updates to [.gitignore](.gitignore)

## Java

- [ ] Update exercism exercises 
  - [ ] `for d in java/*/ ; do (cd "$d" && dir_name="${d#java/}"; exercism download --exercise="${dir_name%/}" --track=java); done`
- [ ] Update spotbugs versions in 
  - [ ] [java/spotbugs.gradle](java/spotbugs.gradle) from https://github.com/spotbugs/spotbugs-gradle-plugin#spotbugs-version-mapping
