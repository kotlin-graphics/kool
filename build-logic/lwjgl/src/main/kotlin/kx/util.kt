package kx

import kx.LwjglModules.*
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.internal.os.OperatingSystem.*
import org.gradle.kotlin.dsl.accessors.runtime.addExternalModuleDependencyTo

enum class LwjglModules(val hasNative: Boolean = true) {
    assimp,
    bgfx,
    bullet,
    cuda(false),
    driftfx,
    egl(false),
    glfw,
    jawt(false),
    jemalloc,
    libdivide,
    llvm,
    lmdb,
    lz4,
    meow,
    meshoptimizer,
    nanovg,
    nfd,
    nuklear,
    odbc(false),
    openal,
    opencl(false),
    opengl,
    opengles,
    openvr,
    opus,
    par,
    remotery,
    rpmalloc,
    shaderc,
    spvc,
    sse,
    stb,
    tinyexr,
    tinyfd,
    tootle,
    vma,
    vulkan(false),
    xxhash,
    yoga,
    zstd
}

object LwjglPreset {
    val none = emptyArray<LwjglModules>()
    val everything = LwjglModules.values()
    val gettingStarted = arrayOf(assimp, bgfx, glfw, nanovg, nuklear, openal, opengl, par, stb, vulkan)
    val minimalOpenGL = arrayOf(assimp, glfw, openal, opengl, stb)
    val minimalOpenGLES = arrayOf(assimp, egl, glfw, openal, opengles, stb)
    val minimalVulkan = arrayOf(assimp, glfw, openal, stb, vulkan)
}

val lwjglNatives = "natives-" + when (current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

@JvmName("lwjglImplementation2")
fun DependencyHandler.lwjglImplementation(modules: Array<LwjglModules>) =
    lwjglImplementation(*modules)

fun DependencyHandler.lwjglImplementation(vararg modules: LwjglModules) {
    add(false, "")
    for (m in modules)
        add(false, "-$m")
}

fun DependencyHandler.lwjglTestImplementation(modules: List<LwjglModules>) {
    add(true, "")
    for (m in modules)
        add(true, "-$m")
}

private fun DependencyHandler.add(test: Boolean, module: String) {
    add(if (test) "testImplementation" else "implementation", "org.lwjgl:lwjgl$module")
    addExternalModuleDependencyTo(
        this, if (test) "testRuntimeOnly" else "runtimeOnly", "org.lwjgl", "lwjgl",
        null, null, lwjglNatives, null, null)
}