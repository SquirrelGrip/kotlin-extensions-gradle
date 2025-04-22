import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

group = "com.github.squirrelgrip"
version = "1.0-SNAPSHOT"

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("io.github.robwin.jgitflow")
    id("com.github.ben-manes.versions")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    mavenLocal()
}

tasks.register("listSubprojects") {
    doLast {
        if (subprojects.isEmpty()) {
            println("No subprojects found.")
        } else {
            subprojects.forEach { subproject ->
                println(subproject.name)
            }
        }
    }
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
    gradleReleaseChannel="current"
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}