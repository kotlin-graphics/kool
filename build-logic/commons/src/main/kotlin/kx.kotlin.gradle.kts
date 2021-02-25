plugins {
    `java-library`
    //    id("com.example.jacoco")
    kotlin("jvm")
}

//group = "com.example.myproduct"

//java {
//    sourceCompatibility = JavaVersion.VERSION_1_8
//    targetCompatibility = JavaVersion.VERSION_1_8
//}

dependencies {
    implementation(platform("kx.platform:source"))

    testImplementation(platform("kx.platform:test"))
    //    testImplementation("org.junit.jupiter:junit-jupiter-api")
    //    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
