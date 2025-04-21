group = "com.github.squirrelgrip"
version = "1.0-SNAPSHOT"

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("io.github.robwin.jgitflow")
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