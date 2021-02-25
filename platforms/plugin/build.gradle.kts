plugins {
    `java-platform`
}

group = "kx.platform"

dependencies {
    constraints {
        api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
        api("org.jetbrains.dokka:dokka-gradle-plugin:1.4.20")
        api("org.jetbrains.dokka:dokka-core:1.4.20")
    }
}
