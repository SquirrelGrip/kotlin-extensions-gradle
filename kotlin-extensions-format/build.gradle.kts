plugins {
    id("extensions.conventions")
}

dependencies {
    implementation(project(":kotlin-extensions-jvm"))

    implementation(platform(libs.jackson.bom))

    implementation(libs.jackson.annotations)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.datatype.jdk8)
    implementation(libs.jackson.datatype.jsr310)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.kotlin.stdlib)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter)
}
