plugins {
    `kotlin-dsl`
}

dependencies {

    implementation(platform("kx.platform:plugin"))

    implementation("org.jetbrains.dokka:dokka-gradle-plugin")
    implementation("org.jetbrains.dokka:dokka-core")
}