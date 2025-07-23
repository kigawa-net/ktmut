package net.kigawa.ktmut.annotations

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class NotNull(val message: String = "Value cannot be null")