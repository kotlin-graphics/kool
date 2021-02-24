plugins {
    `java-platform`
}

group = "com.example.platform"

// allow the definition of dependencies to other platforms like the Spring Boot BOM
//javaPlatform.allowDependencies()

dependencies {
    constraints {
//        api("org.apache.juneau:juneau-marshall:8.2.0")
    }
}
