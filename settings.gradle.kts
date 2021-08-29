rootProject.name = "kool"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
    }
}

gradle.rootProject {
    version = "0.9.0+24"
}

//includeBuild("../build-logic")