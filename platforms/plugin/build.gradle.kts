plugins {
    `java-platform`
}

group = "kx.platform"
version = "0.0.1"

dependencies {
    constraints {

        api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")

        api("org.jetbrains.dokka:dokka-gradle-plugin:1.4.20")
        api("org.jetbrains.dokka:dokka-core:1.4.20")

        api("com.github.johnrengelman.shadow:com.github.johnrengelman.shadow.gradle.plugin:6.1.0")
    }
}
