plugins {
    `java-platform`
}

group = "com.example.platform"

dependencies {
    constraints {
        api("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.4.30")
    }
}
