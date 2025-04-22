plugins {
    id("extensions.conventions")
}

dependencies {
    implementation(project(":kotlin-extensions-format"))
    implementation(project(":kotlin-extensions-jvm"))

    implementation(platform(libs.jackson.bom))

    implementation(libs.jackson.dataformat.properties)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.platform.launcher)

    testRuntimeOnly(libs.junit.jupiter.engine)
}