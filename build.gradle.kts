import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.gradle.internal.os.OperatingSystem.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `maven-publish`
    id("kx.kotlin")
    id("kx.dokka")
    id("com.github.johnrengelman.shadow").version("6.1.0")
//    id("org.jetbrains.dokka") version "1.4.20"
//    id("docs")
}

group = "com.github.kotlin_graphics"
val moduleName = "$group.kool"

val kotestVersion = "4.3.2"
val lwjglVersion = "3.2.3"
val lwjglNatives = "natives-" + when (current()) {
    WINDOWS -> "windows"
    LINUX -> "linux"
    else -> "macos"
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/dokka")
    maven("https://dl.bintray.com/kotlin/kotlinx/")
}

dependencies {

    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))
    listOf("", "-jemalloc").forEach {
        implementation("org.lwjgl", "lwjgl$it")
        runtimeOnly("org.lwjgl", "lwjgl$it", classifier = lwjglNatives)
    }

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")

    testImplementation(kotlin("test-junit5"))
    listOf("engine", "api", "params").forEach {
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-$it:5.6.2")
    }
}

java.modularity.inferModulePath.set(true)

tasks {

//    dokkaHtml {
//        enabled = System.getenv("JITPACK") != "true"
//        dokkaSourceSets.configureEach {
//            sourceLink {
//                localDirectory.set(file("src/main/kotlin"))
//                remoteUrl.set(URL("https://github.com/kotlin-graphics/glm/tree/master/src/main/kotlin"))
//                remoteLineSuffix.set("#L")
//            }
//        }
//    }
//
//    val dokkaHtmlJar by register<Jar>("dokkaHtmlJar") {
//        dependsOn(dokkaHtml)
//        from(dokkaHtml.get().outputDirectory.get())
//        archiveClassifier.set("html-doc")
//    }
//
//    val dokkaJavadocJar by register<Jar>("dokkaJavadocJar") {
//        dependsOn(dokkaJavadoc)
//        from(dokkaJavadoc.get().outputDirectory.get())
//        archiveClassifier.set("javadoc")
//    }
//
//    project.artifacts {
//        archives(dokkaJavadocJar)
//        archives(dokkaHtmlJar)
//    }

    withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs += listOf("-Xinline-classes", "-Xopt-in=kotlin.RequiresOptIn")
        }
        sourceCompatibility = "11"
    }

    compileJava { // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
        options.compilerArgs = listOf("--patch-module", "$moduleName=${sourceSets.main.get().output.asPath}")
    }

    withType<Test> { useJUnitPlatform() }
}

publishing {
    publications.create<MavenPublication>("mavenJava") {
        from(components["java"])
    }
    repositories.maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/kotlin-graphics/kool")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

// == Add access to the 'modular' variant of kotlin("stdlib"): Put this into a buildSrc plugin and reuse it in all your subprojects
configurations.all { attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 11) }

java.withSourcesJar()