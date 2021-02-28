
dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        maven("https://dl.bintray.com/kotlin/dokka")
    }
}

includeBuild("../platforms")

rootProject.name = "build-logic"

include("8")
include("11")
include("commons")
include("docs")
include("lwjgl")
