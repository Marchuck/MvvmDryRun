package pl.marczak.mvvmdryrun.base.validators


import java.io.InvalidClassException
import java.util.ArrayList

class ValidationContext {
    val validators = ArrayList<Validator>()

    fun addValidator(validator: Validator) {
        validators.add(validator)
    }

    fun validate(): Boolean {
        var hasValidationErrors = false
        for (validator in validators) {
            try {
                val validationResult = validator.validate()
                if (!validationResult) {
                    hasValidationErrors = true
                }
            } catch (ex: InvalidClassException) {
                return false
            }

        }

        return !hasValidationErrors
    }
}
