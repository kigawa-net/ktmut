plugins {
    kotlin("jvm") version "2.0.21"
}

allprojects {
    group = "net.kigawa"
    version = "1.0.0"

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}


subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        testImplementation(kotlin("test"))
        testImplementation("junit:junit:4.13.2")
    }

    tasks.test {
        useJUnitPlatform()
    }

    kotlin {
        jvmToolchain(17)
    }
}