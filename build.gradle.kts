import org.jetbrains.dokka.gradle.DokkaTask
import org.gradle.internal.os.OperatingSystem.*

plugins {
    java
    kotlin("jvm") version "1.3.72"
    id("org.jetbrains.dokka") version "0.10.1"
    id("com.github.johnrengelman.shadow").version("5.2.0")
}

group = "com.github.kotlin_graphics"
val moduleName = "$group.kool"

val kotestVersion = "4.0.5"
val lwjglVersion = "3.2.3"
val lwjglNatives = when(current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    listOf("", "-jemalloc").forEach {
        implementation("org.lwjgl:lwjgl$it:$lwjglVersion")
        runtimeOnly("org.lwjgl:lwjgl$it:$lwjglVersion:natives-$lwjglNatives")
    }

    listOf("runner-junit5", "assertions-core", "runner-console"/*, "property"*/).forEach {
        testImplementation("io.kotest:kotest-$it-jvm:$kotestVersion")
    }
}

tasks {
    val dokka by getting(DokkaTask::class) {
        outputFormat = "html"
        outputDirectory = "$buildDir/dokka"
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-XXLanguage:+InlineClasses, -Xopt-in=kotlin.RequiresOptIn")
        }
        sourceCompatibility = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
        sourceCompatibility = "1.8"
    }

    withType<Test> { useJUnitPlatform() }
}

val dokkaJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles Kotlin docs with Dokka"
    archiveClassifier.set("javadoc")
    from(tasks.dokka)
}

val sourceJar = task("sourceJar", Jar::class) {
    dependsOn(tasks["classes"])
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(sourceJar)
    archives(dokkaJar)
}