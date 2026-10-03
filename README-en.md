# Commonmark-Kotlin

[English Version](README-en.md) | [中文版本](README.md)

[![License](https://img.shields.io/badge/License-BSD%202--Clause-orange.svg)](https://opensource.org/licenses/BSD-2-Clause)
[![Kotlin](https://img.shields.io/badge/kotlin-multiplatform-blue.svg?logo=kotlin)]([http://kotlinlang.org](https://www.jetbrains.com/kotlin-multiplatform/))

A Kotlin Multiplatform library for parsing CommonMark Markdown syntax. This project is a fork
of [commonmark-kotlin by Darrious Liu](https://github.com/darriousliu/commonmark-kotlin), which
converts all Java files of the original [commonmark-java](https://github.com/commonmark/commonmark-java)
project to Kotlin to support Kotlin Multiplatform.

This library aims to enable commonmark-java to be used in Kotlin Multiplatform, providing parsing
and rendering functions for CommonMark Markdown syntax.

## Features

- 🚀 **Kotlin Multiplatform**: Supports Android, iOS, and JVM platforms
- 📝 **CommonMark Compliant**: Full support for CommonMark specification
- 🔧 **Extensible**: Support for various extensions
- 🎯 **Type Safe**: Written entirely in Kotlin with type safety

## Supported Platforms

- **Android** - Android applications
- **JVM** - Java Virtual Machine (Desktop applications, servers)
- **iOS / macOS / watchOS / tvOS** - Apple platforms (Kotlin/Native)
- **Windows / Linux** - Desktop native platforms (MinGW / Kotlin/Native)
- **JS / WasmJS** - Browsers and Node.js

## Extensions

This library includes several useful extensions:

- **commonmark-ext-autolink** - Automatic link detection
- **commonmark-ext-footnotes** - Footnotes support
- **commonmark-ext-gfm-strikethrough** - GitHub Flavored Markdown strikethrough
- **commonmark-ext-gfm-tables** - GitHub Flavored Markdown tables
- **commonmark-ext-heading-anchor** - Title anchor point
- **commonmark-ext-image-attributes** - Image attributes
- **commonmark-ext-ins** - Insert text support
- **commonmark-ext-latex** - LaTeX math expressions
- **commonmark-ext-task-list-items** - Task List Items
- **commonmark-ext-yaml-front-matter** - YAML pre-data

## Installation

### Gradle (Kotlin DSL)

Add the following to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        // Alternatively, pull from GitHub Packages (GitHub authentication is
        // required even for public packages)
        // maven("https://maven.pkg.github.com/kamiiroawase/commonmark-kotlin") {
        //     credentials {
        //         username = System.getenv("GITHUB_ACTOR")
        //         password = System.getenv("GITHUB_TOKEN")
        //     }
        // }
    }
}
```

Then, add the dependency in your `build.gradle.kts`:

### Android:

```kotlin
dependencies {
    implementation("io.github.kamiiroawase:commonmark:0.26.0")
    // Extensions (optional)
    implementation("io.github.kamiiroawase:commonmark-ext-autolink:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-footnotes:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-gfm-strikethrough:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-gfm-tables:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-heading-anchor:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-image-attributes:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-ins:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-task-list-items:0.26.0")
    implementation("io.github.kamiiroawase:commonmark-ext-latex:0.26.0")
}
```

### Kotlin Multiplatform:

```kotlin 
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("io.github.kamiiroawase:commonmark:0.26.0")
            // Extensions (optional)
            implementation("io.github.kamiiroawase:commonmark-ext-autolink:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-footnotes:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-gfm-strikethrough:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-gfm-tables:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-heading-anchor:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-image-attributes:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-ins:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-task-list-items:0.26.0")
            implementation("io.github.kamiiroawase:commonmark-ext-latex:0.26.0")
        }
    }
}
```

## Usage

### Basic Usage

```kotlin
val parser = Parser.builder().build()
val document = parser.parse("This is _Sparta_")
val renderer = HtmlRenderer.builder().build()
val html = renderer.render(document) // "This is _Sparta_\n"
```

### With Extensions

```kotlin
val extensions = listOf(TablesExtension.create())
val parser = Parser.builder()
    .extensions(extensions)
    .build()
val renderer = HtmlRenderer.builder()
    .extensions(extensions)
    .build()

val markdown = """
| Feature | Support |
|---------|---------|
| Tables  | ✅      |
| Kotlin  | ✅      |
"""

val document = parser.parse(markdown)
val html = renderer.render(document)
```

### Example

You can refer to [Example](https://github.com/commonmark/commonmark-java#usage) in commonmark-java

## License & Attribution

This project is published under the [BSD 2-Clause License](LICENSE.txt), same as upstream.

- The original project [commonmark-java](https://github.com/commonmark/commonmark-java),
  Copyright (c) 2015, Robin Stocker and contributors
- The Kotlin Multiplatform port [commonmark-kotlin](https://github.com/darriousliu/commonmark-kotlin),
  Copyright (c) Darrious Liu
- Modifications in this fork, Copyright (c) 2026 kamiiroawase

As required by the BSD 2-Clause License, redistributions in source or binary form must retain
the copyright notices above and the license text.

## Publishing (maintainers)

Artifacts are published to **Maven Central** (coordinates `io.github.kamiiroawase`) and
**GitHub Packages**. Push a `v*` tag or manually trigger the
[publish workflow](.github/workflows/build-publish-release.yml). Configure the following in
repository Settings → Secrets → Actions first:

| Secret | Purpose |
| --- | --- |
| `ORG_GRADLE_PROJECT_mavenCentralUsername` / `ORG_GRADLE_PROJECT_mavenCentralPassword` | Central Portal (central.sonatype.com) account and API token; the `io.github.kamiiroawase` namespace must be verified first |
| `ORG_GRADLE_PROJECT_signingInMemoryKeyId` | GPG key ID (last 8 digits); the public key must be uploaded to keyserver.ubuntu.com |
| `ORG_GRADLE_PROJECT_signingInMemoryKey` | GPG private key (ASCII armor) |
| `ORG_GRADLE_PROJECT_signingInMemoryKeyPassword` | GPG private key passphrase (empty if none) |

GitHub Packages uses the workflow's built-in `GITHUB_TOKEN`; no extra setup is needed. To publish locally:

```bash
# GitHub Packages (provide credentials via environment variables; the property
# name must match the repository name's casing)
ORG_GRADLE_PROJECT_GitHubPackagesUsername=<GitHub username> \
ORG_GRADLE_PROJECT_GitHubPackagesPassword=<PAT with write:packages scope> \
./gradlew publishAllPublicationsToGitHubPackagesRepository

# Maven Central
./gradlew publishToMavenCentral
```
