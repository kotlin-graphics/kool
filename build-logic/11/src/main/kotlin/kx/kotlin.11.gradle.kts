package kx

import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kx.kotlin")
    `java-library`
}

tasks {

    withType<KotlinCompile>().all {
        kotlinOptions.jvmTarget = "11"
        sourceCompatibility = "11"
    }

    compileJava { // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
        val module = "${project.group}.${project.name}"
        options.compilerArgs = listOf("--patch-module", "$module=${sourceSets.main.get().output.asPath}")
    }
}

java.modularity.inferModulePath.set(true)

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all { attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 11) }