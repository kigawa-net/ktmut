import net.kigawa.ktmut.annotations.*
import net.kigawa.ktmut.runtime.ValidationEngine
import net.kigawa.ktmut.runtime.exceptions.ValidationException

@Validate
data class User(
    @NotNull(message = "Name is required")
    val name: String?,
    
    @Range(min = 0, max = 150, message = "Age must be between 0 and 150")
    val age: Int,
    
    @Pattern(
        regex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$",
        message = "Invalid email format"
    )
    val email: String
)

fun main() {
    val engine = ValidationEngine()
    
    // Valid user
    val validUser = User("John Doe", 30, "john@example.com")
    val result1 = engine.validate(validUser)
    println("Valid user - Is valid: ${result1.isValid}")
    
    // Invalid user
    val invalidUser = User(null, 200, "invalid-email")
    val result2 = engine.validate(invalidUser)
    println("Invalid user - Is valid: ${result2.isValid}")
    println("Errors: ${result2.getErrorMessages()}")
    
    // Throwing exception for invalid data
    try {
        if (!result2.isValid) {
            throw ValidationException(result2)
        }
    } catch (e: ValidationException) {
        println("Validation exception: ${e.message}")
    }
}