plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "kotlin-extensions"
include("kotlin-extensions-csv")
include("kotlin-extensions-excel")
include("kotlin-extensions-format")
include("kotlin-extensions-javaprops")
include("kotlin-extensions-json")
include("kotlin-extensions-jvm")
include("kotlin-extensions-protobuf")
include("kotlin-extensions-reflection")
include("kotlin-extensions-xml")
include("kotlin-extensions-yaml")
