plugins {
    id("extensions.conventions")
}

dependencies {
    implementation(libs.kotlin.reflect)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.platform.launcher)

    testRuntimeOnly(libs.junit.jupiter.engine)
}
