plugins {
    id("extensions.conventions")
}

dependencies {
    implementation(project(":kotlin-extensions-format"))
    implementation(project(":kotlin-extensions-jvm"))

    implementation(platform(libs.jackson.bom))

    implementation(libs.jackson.dataformat.xml)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter)
}