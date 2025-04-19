plugins {
    id("extensions.conventions")
}

dependencies {
    implementation(project(":kotlin-extensions-format"))
    implementation(project(":kotlin-extensions-jvm"))

    implementation(libs.poi.ooxml)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter)
}
