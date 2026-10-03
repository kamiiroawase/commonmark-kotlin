# Commonmark-Kotlin

[English Version](README-en.md) | [中文版本](README.md)

[![许可证](https://img.shields.io/badge/License-BSD%202--Clause-orange.svg)](https://opensource.org/licenses/BSD-2-Clause)
[![Kotlin](https://img.shields.io/badge/kotlin-multiplatform-blue.svg?logo=kotlin)]([http://kotlinlang.org](https://www.jetbrains.com/kotlin-multiplatform/))

一个用于解析 CommonMark Markdown 语法的 Kotlin
多平台库。本项目 fork 自 [Darrious Liu 的 commonmark-kotlin](https://github.com/darriousliu/commonmark-kotlin)，
后者将原始的 [commonmark-java](https://github.com/commonmark/commonmark-java) 项目的 Java 文件
全部转为 Kotlin 文件，以支持 Kotlin 多平台。

该库旨在让 `commonmark-java` 能用于 Kotlin 多平台，提供 CommonMark Markdown 语法的解析和渲染功能。

## 特性

- 🚀 **Kotlin 多平台**：支持 Android、iOS 和 JVM 平台
- 📝 **兼容 CommonMark**：完全支持 CommonMark 规范
- 🔧 **可扩展**：支持多种扩展
- 🎯 **类型安全**：完全用 Kotlin 编写，具备类型安全

## 支持平台

- **Android** - 安卓应用
- **JVM** - Java 虚拟机（桌面应用、服务器）
- **iOS / macOS / watchOS / tvOS** - 苹果平台（Kotlin/Native）
- **Windows / Linux** - 桌面原生平台（MinGW / Kotlin/Native）
- **JS / WasmJS** - 浏览器与 Node.js

## 扩展

该库包含多个实用扩展：

- **commonmark-ext-autolink** - 自动链接识别
- **commonmark-ext-footnotes** - 脚注支持
- **commonmark-ext-gfm-strikethrough** - GitHub 风格 Markdown 删除线
- **commonmark-ext-gfm-tables** - GitHub 风格 Markdown 表格
- **commonmark-ext-heading-anchor** - 标题锚点
- **commonmark-ext-image-attributes** - 图片属性
- **commonmark-ext-ins** - 插入文本支持
- **commonmark-ext-latex** - LaTeX 数学公式
- **commonmark-ext-task-list-items** - 任务列表项
- **commonmark-ext-yaml-front-matter** - YAML 前置数据

## 安装

### Gradle (Kotlin DSL)

将以下内容添加到 `settings.gradle.kts`：

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
```

然后，在你的 `build.gradle.kts` 中添加依赖：

### Android

```kotlin
dependencies {
    implementation("io.github.kamiiroawase:commonmark:0.26.0")
    // 可选扩展
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

### Kotlin 多平台：

```kotlin 
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("io.github.kamiiroawase:commonmark:0.26.0")
            // 可选扩展
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

## 使用

### 基本用法

```kotlin
val parser = Parser.builder().build()
val document = parser.parse("This is _Sparta_")
val renderer = HtmlRenderer.builder().build()
val html = renderer.render(document) // "This is _Sparta_\n"
```

### 使用扩展

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

### 示例

可参考 commonmark-java 项目的[示例](https://github.com/commonmark/commonmark-java#usage)

## 许可证与致谢

本项目采用 [BSD 2-Clause 许可证](LICENSE.txt) 发布，与上游保持一致。

- 原始项目 [commonmark-java](https://github.com/commonmark/commonmark-java)，
  Copyright (c) 2015, Robin Stocker 及贡献者
- Kotlin 多平台移植版 [commonmark-kotlin](https://github.com/darriousliu/commonmark-kotlin)，
  Copyright (c) Darrious Liu
- 本 fork 的修改，Copyright (c) 2026 kamiiroawase

依据 BSD 2-Clause 的要求，源码与二进制再分发时须保留上述版权声明与许可证文本。

## 发布（维护者）

构件发布到 **Maven Central**（坐标 `io.github.kamiiroawase`）。
推送 `v*` 标签或手动触发 [publish workflow](.github/workflows/build-publish-release.yml) 即可发布，需要先在仓库 Settings → Secrets → Actions 中配置：

| Secret | 用途 |
| --- | --- |
| `ORG_GRADLE_PROJECT_mavenCentralUsername` / `ORG_GRADLE_PROJECT_mavenCentralPassword` | Central Portal（central.sonatype.com）账号与 API Token，需先完成 `io.github.kamiiroawase` 命名空间验证 |
| `ORG_GRADLE_PROJECT_signingInMemoryKeyId` | GPG 密钥 ID（后 8 位），公钥需上传至 keyserver.ubuntu.com |
| `ORG_GRADLE_PROJECT_signingInMemoryKey` | GPG 私钥（ASCII armor） |
| `ORG_GRADLE_PROJECT_signingInMemoryKeyPassword` | GPG 私钥口令（没有则设为空） |

本地发布：

```bash
./gradlew publishToMavenCentral
```