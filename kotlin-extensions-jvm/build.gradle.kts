plugins {
    id("extensions.conventions")
    antlr
}

dependencies {
    implementation(platform(libs.jackson.bom))

    antlr(libs.antlr4)

    implementation(libs.jackson.databind)
    implementation(libs.antlr4.runtime)
    implementation(libs.kotlin.stdlib)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter)
}

tasks.generateGrammarSource {
    outputDirectory = file("${layout.buildDirectory.get()}/generated-src/antlr/main/com/github/squirrelgrip/extension/collection")
    arguments = listOf("-package", "com.github.squirrelgrip.extension.collection", "-visitor")
}

tasks.compileTestKotlin {
    dependsOn(tasks.generateTestGrammarSource)
}

tasks.compileKotlin {
    dependsOn(tasks.generateGrammarSource)
}

//tasks.dokkaJavadoc {
//    dependsOn(tasks.generateGrammarSource)
//}
//
//tasks.dokkaHtmlPartial {
//    dependsOn(tasks.generateGrammarSource)
//}

sourceSets {
    main {
        java {
            srcDir("${layout.buildDirectory.get()}/generated-src/antlr/main")
        }
        kotlin {
            srcDir("src/main/kotlin")
        }
        antlr {
            srcDir("src/main/antlr")
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