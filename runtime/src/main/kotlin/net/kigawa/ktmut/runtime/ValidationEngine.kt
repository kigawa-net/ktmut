package net.kigawa.ktmut.runtime

import net.kigawa.ktmut.annotations.*
import kotlin.reflect.KProperty1
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

class ValidationEngine {
    
    fun <T : Any> validate(obj: T): ValidationResult {
        val errors = mutableListOf<ValidationError>()
        
        obj::class.memberProperties.forEach { property ->
            @Suppress("UNCHECKED_CAST")
            val prop = property as KProperty1<T, Any?>
            val value = prop.get(obj)
            val fieldName = property.name
            
            // NotNull validation
            property.findAnnotation<NotNull>()?.let { annotation ->
                if (value == null) {
                    errors.add(ValidationError(fieldName, annotation.message, value))
                }
            }
            
            // Range validation
            property.findAnnotation<Range>()?.let { annotation ->
                if (value is Number) {
                    val longValue = value.toLong()
                    if (longValue < annotation.min || longValue > annotation.max) {
                        errors.add(ValidationError(fieldName, annotation.message, value))
                    }
                }
            }
            
            // Pattern validation
            property.findAnnotation<Pattern>()?.let { annotation ->
                if (value is String) {
                    val regex = Regex(annotation.regex)
                    if (!regex.matches(value)) {
                        errors.add(ValidationError(fieldName, annotation.message, value))
                    }
                }
            }
        }
        
        return ValidationResult(errors.isEmpty(), errors)
    }
}