package net.kigawa.ktmut.runtime.exceptions

import net.kigawa.ktmut.runtime.ValidationResult

class ValidationException(
    val validationResult: ValidationResult,
    message: String = "Validation failed: ${validationResult.getErrorMessages().joinToString(", ")}"
) : RuntimeException(message)