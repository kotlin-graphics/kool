plugins {
    `kotlin-dsl`
}

dependencies {

    implementation(platform("kx.platform:plugin"))

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
}