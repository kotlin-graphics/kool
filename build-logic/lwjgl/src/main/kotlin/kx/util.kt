package kx

import kx.LwjglModules.*
import org.gradle.api.artifacts.CacheableRule
import org.gradle.api.artifacts.ComponentMetadataContext
import org.gradle.api.artifacts.ComponentMetadataRule
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.model.ObjectFactory
import org.gradle.internal.os.OperatingSystem.*
import org.gradle.kotlin.dsl.accessors.runtime.addExternalModuleDependencyTo
import org.gradle.kotlin.dsl.named
import org.gradle.nativeplatform.MachineArchitecture
import org.gradle.nativeplatform.OperatingSystemFamily
import javax.inject.Inject

@CacheableRule
abstract class LwjglRule : ComponentMetadataRule {

    data class NativeVariant(val os: String, val arch: String, val classifier: String)

    private val nativeVariants = listOf(
        NativeVariant(OperatingSystemFamily.LINUX, "arm32", "natives-linux-arm32"),
        NativeVariant(OperatingSystemFamily.LINUX, "arm64", "natives-linux-arm64"),
        NativeVariant(OperatingSystemFamily.WINDOWS, "x86", "natives-windows-x86"),
        NativeVariant(OperatingSystemFamily.WINDOWS, "x86-64", "natives-windows"),
        NativeVariant(OperatingSystemFamily.MACOS, "x86-64", "natives-macos"))

    @get:Inject abstract val objects: ObjectFactory

    override fun execute(context: ComponentMetadataContext) {
        context.details.withVariant("runtime") {
            println(this)
            attributes {
                attribute(OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named("none"))
                attribute(MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named("none"))
            }
        }
        nativeVariants.forEach { variantDefinition ->
            context.details.addVariant("${variantDefinition.classifier}-runtime", "runtime") {
                attributes {
                    attribute(OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named(variantDefinition.os))
                    attribute(MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named(variantDefinition.arch))
                }
                withFiles {
                    addFile("${context.details.id.name}-${context.details.id.version}-${variantDefinition.classifier}.jar")
                }
            }
        }
    }
}

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
    add(false, "", true)
    for (m in modules)
        add(false, "-$m", m.hasNative)
}

fun DependencyHandler.lwjglTestImplementation(modules: List<LwjglModules>) {
    add(true, "", true)
    for (m in modules)
        add(true, "-$m", m.hasNative)
}

private fun DependencyHandler.add(test: Boolean, module: String, native: Boolean) {
    add(if (test) "testImplementation" else "implementation", "org.lwjgl:lwjgl$module")
    if (native)
        addExternalModuleDependencyTo(
            this, if (test) "testRuntimeOnly" else "runtimeOnly", "org.lwjgl", "lwjgl",
            null, null, lwjglNatives, null, null)
}