package net.kigawa.ktmut.annotations

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Range(
    val min: Long = Long.MIN_VALUE,
    val max: Long = Long.MAX_VALUE,
    val message: String = "Value must be within range"
)