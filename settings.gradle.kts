rootProject.name = "kool"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
    }
//    includeBuild("../lwjgl3-gradle")
}

gradle.rootProject {
    group = "kotlin.graphics"
    version = "0.9.78"
}

//includeBuild("../build-logic")