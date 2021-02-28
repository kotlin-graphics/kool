package kx

import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.get

plugins { `maven-publish` }

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
    //    repositories.maven {
    //        name = "GitHubPackages"
    //        url = uri("https://maven.pkg.github.com/kotlin-graphics/kool")
    //        credentials {
    //            username = System.getenv("GITHUB_ACTOR")
    //            password = System.getenv("GITHUB_TOKEN")
    //        }
    //    }
}