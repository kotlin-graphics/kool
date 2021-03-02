import kx.LwjglModules.jemalloc
import kx.LwjglRule
import kx.lwjglImplementation

plugins {
    `kotlin-dsl`
    id("kx.kotlin.11")
    id("kx.lwjgl")
    id("kx.dokka")
    id("kx.jitpack")
}

group = "com.github.kotlin_graphics"

//configurations["runtimeClasspath"].attributes {
//    attribute(OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named("windows"))
//    attribute(MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named("x86-64"))
//}
//configurations["testRuntimeClasspath"].attributes {
//    attribute(OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named("windows"))
//    attribute(MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named("x86-64"))
//}

dependencies {

    lwjglImplementation(jemalloc)

//    components.withModule<LwjglRule>("org.lwjgl:lwjgl")
//    implementation("org.lwjgl:lwjgl:3.2.3")
}