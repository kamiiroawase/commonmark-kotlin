plugins {
    id("com.vanniktech.maven.publish")
}

// 本 fork 的发布坐标：GitHub 用户名 kamiiroawase 对应 Central Portal 上
// 可通过 GitHub 命名空间验证的 io.github.kamiiroawase
group = "io.github.kamiiroawase"
version = findProperty("version")?.toString().orEmpty()

val commonPom = Action<MavenPom> {
    name.set("commonmark-kotlin")
    description.set(
        "A Kotlin Multiplatform library for parsing and rendering CommonMark Markdown, " +
            "a fork of commonmark-kotlin by Darrious Liu, based on commonmark-java"
    )
    url.set("https://github.com/kamiiroawase/commonmark-kotlin")

    licenses {
        license {
            name.set("BSD 2-Clause License")
            url.set("https://opensource.org/licenses/BSD-2-Clause")
        }
    }
    developers {
        developer {
            id.set("kamiiroawase")
            name.set("kamiiroawase")
            url.set("https://github.com/kamiiroawase")
        }
    }
    scm {
        url.set("https://github.com/kamiiroawase/commonmark-kotlin")
        connection.set("scm:git:git://github.com/kamiiroawase/commonmark-kotlin.git")
        developerConnection.set("scm:git:ssh://git@github.com/kamiiroawase/commonmark-kotlin.git")
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/kamiiroawase/commonmark-kotlin")
            // 凭证读取项目属性 GitHubPackagesUsername / GitHubPackagesPassword
            // （属性名与仓库名大小写一致；可用 -P 或
            // ORG_GRADLE_PROJECT_GitHubPackagesUsername 环境变量提供）
            credentials(PasswordCredentials::class)
        }
    }
    publications {
        publications.withType<MavenPublication> {
            groupId = project.group.toString()
            version = project.version.toString()

            pom(commonPom)
        }
    }
}

mavenPublishing {
    // 插件 0.34.0 起固定发布到 Central Portal（OSSRH 已停用）；
    // autoPublish = true 表示校验通过后自动发布上线
    publishToMavenCentral(true)

    signAllPublications()

    pom(commonPom)
}
