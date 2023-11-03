import kool.gen.GenerateCode
import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.lwjgl.Lwjgl.Module.jemalloc
import org.lwjgl.lwjgl
import java.util.*

plugins {
    embeddedKotlin("jvm")
    id("org.lwjgl.plugin") version "0.0.34"
    id("elect86.magik") version "0.3.3"
    `maven-publish`
    signing
//    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

dependencies {
    lwjgl { implementation(jemalloc) }
    testImplementation(embeddedKotlin("test"))
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

java {
    withJavadocJar()
    withSourcesJar()
}
tasks.withType<Javadoc> {
    isFailOnError = false
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("mavenCentral") {
            groupId = "io.github.kotlin-graphics"
            artifactId = "kool"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("kool")
                description.set("Buffer utils")
                url.set("https://github.com/kotlin-graphics/kool")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://choosealicense.com/licenses/mit/")
                    }
                }
                developers {
                    developer {
                        id.set("elect86")
                        name.set("Giuseppe Barbieri")
                        email.set("elect86@gmail.com")
                    }
                    developer {
                        id.set("bixilon")
                        name.set("Moritz Zwerger")
                        email.set("bixilon@bixilon.de")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/kotlin-graphics/kool.git")
                    developerConnection.set("scm:git:ssh://git@github.com:kotlin-graphics/kool.git")
                    url.set("https://github.com/kotlin-graphics/kool")
                }
            }
        }
    }
    repositories {
        maven {
            name = "mavenCentral"
            credentials {
                username = project.properties["NEXUS_USERNAME"].toString()
                password = project.properties["NEXUS_PASSWORD"].toString()
            }

            url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
        }
    }
}

signing {
    val rawKey = project.properties["SIGNING_KEY"]?.toString() ?: return@signing
    val key = String(Base64.getDecoder().decode(rawKey)) // \n is not working in environment variables
    val password = project.properties["SIGNING_KEY_PASSWORD"]?.toString() ?: ""
    useInMemoryPgpKeys(key, password)
    sign(publishing.publications["mavenCentral"])
}
