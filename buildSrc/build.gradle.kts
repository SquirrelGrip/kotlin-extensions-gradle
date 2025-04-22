plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.0.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.20")
    implementation("io.github.robwin:jgitflow-gradle-plugin:0.6.0")
    implementation("com.github.ben-manes:gradle-versions-plugin:0.52.0")
    implementation("se.bjurr.gradle.update-versions:se.bjurr.gradle.update-versions.gradle.plugin:0.3.4")
}