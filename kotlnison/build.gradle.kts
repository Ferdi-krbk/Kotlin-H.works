plugins {
    kotlin("jvm") version "1.9.0"
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.5")
    implementation("io.ktor:ktor-server-netty:2.3.5")
    implementation("io.ktor:ktor-html-builder:2.3.5")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}