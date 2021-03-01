package kx

import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.gradle.kotlin.dsl.`java-library`
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kx.kotlin")
    `java-library`
}

tasks {

    withType<KotlinCompile>().all {
        kotlinOptions.jvmTarget = "1.8"
        sourceCompatibility = "1.8"
    }
}

java.modularity.inferModulePath.set(false)

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all { attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 8) }