package net.kigawa.ktmut.runtime

data class ValidationResult(
    val isValid: Boolean,
    val errors: List<ValidationError> = emptyList()
) {
    fun hasErrors(): Boolean = errors.isNotEmpty()
    
    fun getErrorMessages(): List<String> = errors.map { it.message }
}

data class ValidationError(
    val field: String,
    val message: String,
    val value: Any?
)