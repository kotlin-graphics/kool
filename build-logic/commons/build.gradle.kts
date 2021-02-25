plugins {
    `kotlin-dsl`
}

dependencies {

    implementation(platform("kx.platform:plugin"))

    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin")
}