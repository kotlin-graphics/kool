import kool.gen.GenerateCode
import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.lwjgl.Lwjgl.Module.jemalloc
import org.lwjgl.lwjgl

plugins {
    kotlin("jvm") version embeddedKotlinVersion
    id("org.lwjgl.plugin") version "0.0.34"
    id("elect86.magik") version "0.3.2"
    `maven-publish`
//    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

dependencies {
    lwjgl { implementation(jemalloc) }
    testImplementation(kotlin("test"))
}

kotlin.jvmToolchain { languageVersion.set(JavaLanguageVersion.of(8)) }

tasks {
    withType<KotlinCompile<*>>().all {
        kotlinOptions {
            languageVersion = "1.8"
            freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn")
        }
    }
    val generateCode by registering(GenerateCode::class)
    kotlin.sourceSets { main { kotlin.srcDir(generateCode) } }
    test { useJUnitPlatform() }
}

publishing {
    publications {
        createGithubPublication {
            from(components["java"])
            suppressAllPomMetadataWarnings()
        }
    }
    repositories { github { domain = "kotlin-graphics/mary" } }
}

java.withSourcesJar()