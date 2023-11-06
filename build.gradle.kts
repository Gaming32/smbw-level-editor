plugins {
    java
}

group = "io.github.gaming32"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.luben:zstd-jni:1.5.5-10")
    implementation("com.google.protobuf:protobuf-java:3.25.0") // ByteString
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("org.apache.commons:commons-compress:1.24.0")
    implementation("it.unimi.dsi:fastutil-core:8.5.12")
    implementation("com.formdev:flatlaf:3.2.5")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
