import kx.LwjglModules.jemalloc
import kx.lwjglImplementation

plugins {
    val build = "0.7.0+56"
    id("kx.kotlin.11") version build
    id("kx.lwjgl") version build
    id("kx.dokka") version build
    id("kx.publish") version build
    java
}

version = "0.9.0+19"

dependencies {
    lwjglImplementation(jemalloc)
}