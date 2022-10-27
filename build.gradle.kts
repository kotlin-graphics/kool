import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.lwjgl.lwjgl
import org.lwjgl.lwjgl.Module.jemalloc
//import org.lwjgl.lwjgl.implementation

plugins {
//    fun kx(vararg p: Pair<String, String>) = p.forEach { id("io.github.kotlin-graphics.${it.first}") version it.second }
//    kx("base" to "0.0.9",
//       "publish" to "0.0.5",
//       "utils" to "0.0.5")
    kotlin("jvm") version embeddedKotlinVersion
    id("org.lwjgl.plugin") version "0.0.29"
    id("elect86.magik") version "0.2.7"
    `maven-publish`
}

repositories { mavenCentral() }

dependencies {
    implementation(kotlin("stdlib-jdk8", embeddedKotlinVersion))
    lwjgl { implementation(jemalloc) }
    implementation("io.kotest:kotest-runner-junit5:5.5.2")
    implementation("io.kotest:kotest-assertions-core:5.5.2")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks {
    withType<KotlinCompile<*>>().all {
        kotlinOptions {
            freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn")
        }
    }
}

publishing {
    publications {
        createGithubPublication {
//            if (project != rootProject)
//                artifactId = "${rootProject.name}-${project.name}"
            //        version = rootProject.version
//                    println(artifactId)
//                    println(version)
            from(components["java"])
            suppressAllPomMetadataWarnings()
        }
    }
    repositories {
        github {
            domain = "kotlin-graphics/mary"
        }
    }
}