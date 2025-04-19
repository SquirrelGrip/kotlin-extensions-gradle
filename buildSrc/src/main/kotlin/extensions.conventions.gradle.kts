plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
    `version-catalog`
    id("signing")
}

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    jvmToolchain(17)
}

sourceSets {
    main {
        kotlin {
            srcDir("src/main/kotlin")
        }
        resources {
            srcDir("src/main/resources")
        }
    }
    test {
        kotlin {
            srcDir("src/test/kotlin")
        }
        resources {
            srcDir("src/test/resources")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.processTestResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}