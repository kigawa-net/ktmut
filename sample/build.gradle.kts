plugins {
    application
    // TODO: Enable when gradle-plugin is working
    // id("net.kigawa.ktmut")
}

dependencies {
    implementation(project(":annotations"))
    implementation(project(":runtime"))
}

// TODO: Enable when gradle-plugin is working
// ktmut {
//     enabled = true
//     generateValidationMethods = true
// }

application {
    mainClass.set("SampleKt")
}