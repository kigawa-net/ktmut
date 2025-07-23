package net.kigawa.ktmut.annotations

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Pattern(
    val regex: String,
    val message: String = "Value does not match required pattern"
)