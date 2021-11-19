import org.lwjgl.Lwjgl
import org.lwjgl.Lwjgl.Module.jemalloc

plugins {
    fun kx(vararg p: Pair<String, String>) = p.forEach { id("io.github.kotlin-graphics.${it.first}") version it.second }
    kx("base" to "0.0.9",
       "publish" to "0.0.5",
       "utils" to "0.0.5")
    id("org.lwjgl.plugin") version "0.0.18"
}

dependencies {
    Lwjgl {
        release.`3_2_3`
        snapshot
        implementation(jemalloc) }
}