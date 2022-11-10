import kool.gen.GenerateCode
import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.lwjgl.lwjgl
import org.lwjgl.lwjgl.Module.jemalloc

//import org.lwjgl.lwjgl.implementation

plugins {
    kotlin("jvm") version embeddedKotlinVersion
    id("org.lwjgl.plugin") version "0.0.29"
    id("elect86.magik") version "0.3.1"
    `maven-publish`
}

repositories { mavenCentral() }

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    lwjgl { implementation(jemalloc) }
    testImplementation(kotlin("test"))
}

kotlin.jvmToolchain {
    this as JavaToolchainSpec
    languageVersion.set(JavaLanguageVersion.of(8))
}

tasks {
    withType<KotlinCompile<*>>().all {
        kotlinOptions {
//            languageVersion = "1.8"
            freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn", "-Xcontext-receivers")
        }
    }
    val generateCode by registering(kool.gen.GenerateCode::class)
    kotlin.sourceSets {
        main { kotlin.srcDir(generateCode) }
    }
    test { useJUnitPlatform() }
}

publishing {
    publications {
        createGithubPublication {
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

java { withSourcesJar() }