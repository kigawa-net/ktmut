dependencies {
    implementation(project(":annotations"))
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:2.0.21")
    compileOnly("org.jetbrains.intellij.deps:trove4j:1.0.20200330")
    
    testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:2.0.21")
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing:1.5.0")
}