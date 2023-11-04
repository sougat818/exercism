As this is a mono repo for multiple languages, each language has its own set of requirements. All of these instructions are mean for subfolders within each language directory. E.g typescript/hello-world. 

## Go

### Pre requisites

* exercism CLI
* go

#### Test

`go test`

#### Lint

`golangci-lint run`

### Adding a new Exercise

`exercism download --exercise=exerciseName --track=go`

The exercism codebase doesn't have linter so we add them by

* Create .golangci.yml
```
run:
  concurrency: 4
  tests: false

linters:
  enable-all: false
  enable:
    - revive
    - deadcode
    - errcheck
    - gosimple
    - govet
    - ineffassign
    - staticcheck
    - structcheck
    - typecheck
    - varcheck
    - asciicheck
    - bidichk
    - bodyclose
    - containedctx
    - contextcheck
    - decorder
    - dogsled
    - dupl
    - durationcheck
    - errname
    - errorlint
    - cyclop
    - cyclop
    - errchkjson
    - exhaustive
    - exhaustivestruct
    - exportloopref
    - forbidigo
    - forcetypeassert
    - funlen
    - gci
    - gochecknoglobals
    - gochecknoinits
    - gocognit
    - goconst
    - gocritic
    - gocyclo
    - godox
    - goerr113
    - gofmt
    - gofumpt
    - goheader
    - goimports
    - gomnd
    - gomoddirectives
    - gomodguard
    - goprintffuncname
    - gosec
    - grouper
    - ifshort
    - importas
    - ireturn
    - lll
    - maintidx
    - makezero
    - misspell
    - nakedret
    - nestif
    - nilerr
    - nilnil
    - nlreturn
    - noctx
    - prealloc
    - predeclared
    - promlinter
    - rowserrcheck
    - sqlclosecheck
    - stylecheck
    - tagliatelle
    - tenv
    - thelper
    - tparallel
    - unconvert
    - unparam
    - varnamelen
    - wastedassign
    - whitespace
    - wrapcheck

linters-settings:
  tests: false

```

### Submit solution to exercism

`exercism submit exerciseName.go`


## Java

### Pre requisites

* exercism CLI
* sdkman
* Java 21
* Gradle

#### Test

`gradle test`

#### Lint & Test

`gradle check`

### Adding a new Exercise

`exercism download --exercise=exerciseName --track=java`

Add exercise name to [java/settings.gradle](java/settings.gradle)
after commit 
move classes to a package exercism

build.gradle
`
plugins {
id 'info.solidsoft.pitest' version '1.15.0'
}
dependencies {
testImplementation 'org.pitest:pitest-parent:1.1.10'
}

pitest {
targetClasses = ['exercism.*']  //by default "${project.group}.*"
junit5PluginVersion = '1.2.1'
pitestVersion = '1.15.0' //not needed when a default PIT version should be used
threads = 4
outputFormats = ['XML', 'HTML']
timestampedReports = false
}
`
Run `gradle pitest` then check the report
discard these changes if everything looks good


### Submit solution to exercism

`exercism submit exerciseName.java`

## JavaScript

### Pre requisites

* exercism CLI
* nvm
* nodeJS 17
* npm

#### Build

`npm`

#### Tests

`npm test`

#### Lints

`npm run lint`

### Adding a new Exercise

`exercism download --exercise=exerciseName --track=javascript`

The exercism codebase doesn't have prettier so we add them by 

* Adding .prettierignore
```
*.spec.js
*.config.js
```
* Adding lines to .eslintrc
    ```json
  "extends": ["@exercism/eslint-config-javascript", "prettier"],
  "plugins": ["prettier"],
  "env": {
    "jest": true
  },
  "rules": {
    "prettier/prettier": "error",
    "arrow-body-style": "off",
    "prefer-arrow-callback": "off"
  },
    ```
* `npm install eslint-plugin-prettier@latest --save-dev`
* `npm install --save-dev --save-exact prettier`

### Submit solution to exercism

`exercism submit exerciseName.js`

## Python

### Pre requisites

* exercism CLI
* pyenv
* python 3.10.2
* pip install flake8 pytest pylint

#### Test

`pytest`

#### Lint

`pylint exerciseName.py`
`flake8 . --count --exit-zero --max-complexity=10 --max-line-length=127 --statistics`  
`flake8 . --count --select=E9,F63,F7,F82 --show-source --statistics`

### Adding a new Exercise

`exercism download --exercise=exerciseName --track=python`

The exercism codebase doesn't have pylint so we add them by 

* Adding .pylintrc
```
[MASTER]
disable=
  C0114, # missing-module-docstring
  C0116, # missing-function-docstring
```

### Submit solution to exercism

`exercism submit exerciseName.py`

## TypeScript

### Pre requisites

* exercism CLI
* nvm
* nodeJS 17
* yarn

#### Build

`yarn`

#### Tests

`yarn test`

#### Lints

`yarn run lint`

### Adding a new Exercise

`exercism download --exercise=exerciseName --track=typescript`

The exercism codebase doesn't have prettier so we add them by 

* Adding .prettierignore
    ```
    *.test.ts
    ```
* Adding lines to .eslintrc
    ```json
  "extends": ["@exercism/eslint-config-typescript", "prettier"],
  "plugins": ["prettier"],
  "env": {
    "jest": true
  },
  "rules": {
    "prettier/prettier": "error",
    "arrow-body-style": "off",
    "prefer-arrow-callback": "off"
  },
    ```
* `yarn add eslint-plugin-prettier@latest --dev`
* `yarn add --dev --exact prettier`

### Submit solution to exercism

`exercism submit exerciseName.ts`