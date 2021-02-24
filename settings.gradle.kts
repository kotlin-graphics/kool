rootProject.name = "kool"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if(requested.id.id == "docs")
                useModule("com.github.elect86:docs:9c008a8b")//.also { println("found") }
        }
    }
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}


//includeBuild("/home/elect/Downloads/demoModules/build-logic")
includeBuild("platforms")
includeBuild("build-logic")