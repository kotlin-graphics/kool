import kx.LwjglModules.jemalloc
import kx.lwjglImplementation

plugins {
    val build = "0.6.4"
    id("kx.kotlin.8") version build
    id("kx.lwjgl") version build
    id("kx.dokka") version build
    id("kx.jitpack") version build
    java
}

version = "0.9.0"

dependencies {
    lwjglImplementation(jemalloc)
}