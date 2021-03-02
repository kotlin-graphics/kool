plugins {
    `kotlin-dsl`
}

dependencies {

    implementation(platform("kx.platform:plugin:0.0.1"))

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("com.github.johnrengelman.shadow:com.github.johnrengelman.shadow.gradle.plugin")
}