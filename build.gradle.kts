import kx.LwjglModules.jemalloc
import kx.lwjglImplementation

plugins {
    val build = "0.4.8"
    id("kx.kotlin.11") version build
    id("kx.lwjgl") version build
    id("kx.dokka") version build
    java
    `maven-publish`
}

group = "com.github.kotlin.graphics"
version = "0.9.1"

repositories {
    maven("https://repo.repsy.io/mvn/elect/kx")
}

dependencies {
    lwjglImplementation(jemalloc)
}


publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}