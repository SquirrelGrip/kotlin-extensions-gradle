group = "com.github.squirrelgrip"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
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