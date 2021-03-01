import kx.LwjglModules.jemalloc
import kx.lwjglImplementation

plugins {
    `kotlin-dsl`
    `maven-publish`
    id("kx.kotlin.11")
    id("kx.lwjgl")
    id("kx.dokka")
    id("kx.jitpack")
}

group = "com.github.kotlin_graphics"

dependencies {

    implementation(platform("kx.platform:source"))

    lwjglImplementation(jemalloc)
}