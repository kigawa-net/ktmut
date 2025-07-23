package net.kigawa.ktmut.annotations

import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Custom(
    val validator: KClass<*>,
    val message: String = "Custom validation failed"
)