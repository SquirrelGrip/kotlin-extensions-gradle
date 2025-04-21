plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka-javadoc")
    `version-catalog`
    id("signing")
    `maven-publish`
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

tasks.register<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
    destinationDirectory.set(layout.buildDirectory.dir("libs"))
    from(layout.buildDirectory.dir("dokka/javadoc"))
    dependsOn("dokkaGeneratePublicationJavadoc")
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    destinationDirectory.set(layout.buildDirectory.dir("libs"))
    from(sourceSets["main"].allSource)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
            artifact(tasks["javadocJar"])
            artifact(tasks["sourcesJar"])

            groupId = "com.github.squirrelgrip"
            artifactId = project.name
            version = "1.0-SNAPSHOT"

            pom {
                name = project.name
                description = project.description
                url = "https://github.com/SquirrelGrip/root"
                licenses {
                    license {
                        name = "MIT License"
                        url = "http://www.opensource.org/licenses/mit-license.php"
                    }
                }
                developers {
                    developer {
                        name = "Adrian Richter"
                        email = "adrian.richter@gmail.com"
                        timezone = "Australia/Melbourne"
                    }
                }
                scm {
                    connection = "scm:git:git@github.com:SquirrelGrip/root.git"
                    developerConnection = "scm:git:git@github.com:SquirrelGrip/root.git"
                    url = "https://github.com/SquirrelGrip/root"
                }
            }
        }
    }
}

artifacts {
    add("archives", tasks.named("javadocJar"))
}

//ext["signing.gnupg.useLegacyGpg"]=true
//ext["signing.gnupg.optionsFile"]=gnupg-home/gpg.conf
ext["signing.gnupg.executable"]="gpg"
ext["signing.gnupg.homeDir"]="/Users/adrian/.gnupg"
ext["signing.gnupg.keyName"]=System.getenv("GPG_KEYNAME")
ext["signing.gnupg.passphrase"]=System.getenv("GPG_PASSPHRASE")

signing {
    useGpgCmd()
    sign(publishing.publications)
}