package pl.marczak.mvvmdryrun.base.validators

import android.view.View
import android.widget.EditText

class ConfirmedPasswordRepeated(view: View, validationMessage: String, private val _validationContext: ValidationContext)
    : TextValidatorBase(view, validationMessage) {

    override fun isValid(editText: EditText): Boolean {
        if (editText.text == null) {
            return false
        }

        for (validator in _validationContext.validators) {
            if (validator is CorrectPasswordRequired) {
                val password = validator.extractText()
                val confirmPassword = editText.text.toString()
                return password != null && !password.isEmpty() && password == confirmPassword
            }
        }

        return false
    }
}
