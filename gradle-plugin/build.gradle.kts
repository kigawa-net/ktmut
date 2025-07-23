plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

dependencies {
    implementation(project(":compiler-plugin"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
}

gradlePlugin {
    plugins {
        create("ktmut") {
            id = "net.kigawa.ktmut"
            displayName = "KTMUT Gradle Plugin"
            description = "Gradle plugin for KTMUT compiler plugin"
            implementationClass = "net.kigawa.ktmut.gradle.KtmutGradlePlugin"
        }
    }
}