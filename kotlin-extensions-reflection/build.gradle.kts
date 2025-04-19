plugins {
    id("extensions.conventions")
}

dependencies {
    implementation(libs.kotlin.reflect)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter)
}
