plugins {
    `kotlin-dsl`
}

dependencies {

    implementation(platform("kx.platform:plugin:0.0.1"))

    implementation("org.jetbrains.dokka:dokka-gradle-plugin")
    implementation("org.jetbrains.dokka:dokka-core")
}