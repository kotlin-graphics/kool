import java.net.URL

plugins {

    id("org.jetbrains.dokka")
}

val TaskContainer.dokkaHtml: TaskProvider<org.jetbrains.dokka.gradle.DokkaTask>
    get() = named<org.jetbrains.dokka.gradle.DokkaTask>("dokkaHtml")

operator fun <T> NamedDomainObjectProvider<T>.invoke(action: T.() -> Unit) =
    configure(action)

dokkaHtml {
    enabled = System.getenv("JITPACK") != "true"
    dokkaSourceSets.configureEach {
        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl.set(URL("https://github.com/kotlin-graphics/kool/tree/master/src/main/kotlin"))
            remoteLineSuffix.set("#L")
        }
    }
}

val dokkaHtmlJar by register<Jar>("dokkaHtmlJar") {
    dependsOn(dokkaHtml)
    from(dokkaHtml.get().outputDirectory.get())
    archiveClassifier.set("html-doc")
}

val dokkaJavadocJar by register<Jar>("dokkaJavadocJar") {
    dependsOn(dokkaJavadoc)
    from(dokkaJavadoc.get().outputDirectory.get())
    archiveClassifier.set("javadoc")
}

project.artifacts {
    archives(dokkaJavadocJar)
    archives(dokkaHtmlJar)
}