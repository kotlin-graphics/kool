package kx

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

val lwjglNatives = "natives-" + when (current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

fun DependencyHandler.lwjglImplementation(vararg modules: LwjglModules) {
    add(false, "")
    modules.forEach {
        add(false, "-$it")
    }
}

fun DependencyHandler.lwjglTestImplementation(modules: List<LwjglModules>) {
    add(false, "")
    modules.forEach {
        add(false, "-$it")
    }
}

private fun DependencyHandler.add(test: Boolean, module: String) {
    add(if (test) "testImplementation" else "implementation", "org.lwjgl:lwjgl$module")
    addExternalModuleDependencyTo(
        this, if (test) "testRuntimeOnly" else "runtimeOnly", "org.lwjgl", "lwjgl",
        null, null, lwjglNatives, null, null)
}