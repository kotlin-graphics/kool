
dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        maven("https://dl.bintray.com/kotlin/dokka")
    }
}

includeBuild("../platforms")

rootProject.name = "build-logic"

include("commons")
include("docs")
