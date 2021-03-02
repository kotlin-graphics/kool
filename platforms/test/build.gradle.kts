plugins {
    `java-platform`
}

group = "kx.platform"
version = "0.0.1"

// allow the definition of dependencies to other platforms like the JUnit 5 BOM
//javaPlatform.allowDependencies()

dependencies {
    //    api(platform("org.junit:junit-bom:5.7.0"))
    constraints {
        api("io.kotest:kotest-runner-junit5:4.4.1")
        api("io.kotest:kotest-assertions-core:4.4.1")
    }
}
