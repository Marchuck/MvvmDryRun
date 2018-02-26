package pl.marczak.mvvmdryrun.base.validators

import android.databinding.BindingAdapter
import android.view.View
import android.view.ViewParent


object ValidationAdapters {
    @JvmStatic
    @BindingAdapter("validateRequiredField")
    fun setValidateRequiredField(view: View, validationMessage: String) {
        val validationContainer = findValidatedContainerUp(view)
        if (validationContainer != null) {
            validationContainer
                    .getValidationContext()!!
                    .addValidator(FieldRequired(view, validationMessage))
        }
    }

    @JvmStatic
    @BindingAdapter("validateEmail")
    fun setValidateEmail(view: View, validationMessage: String) {
        val validationContainer = findValidatedContainerUp(view)
        if (validationContainer != null) {
            validationContainer
                    .getValidationContext()!!
                    .addValidator(CorrectEmailRequired(view, validationMessage))
        }
    }

    @JvmStatic
    @BindingAdapter("validatePassword")
    fun setValidatePassword(view: View, minLength: MinLengthParams) {
        val validationContainer = findValidatedContainerUp(view)
        if (validationContainer != null) {
            validationContainer
                    .getValidationContext()!!
                    .addValidator(CorrectPasswordRequired(view, minLength))
        }
    }

    @JvmStatic
    @BindingAdapter("validatePasswordConfirmed")
    fun setValidateRepeatPassword(view: View, validationMessage: String) {
        val validationContainer = findValidatedContainerUp(view)
        if (validationContainer != null) {
            val context = validationContainer.getValidationContext()
            validationContainer
                    .getValidationContext()!!
                    .addValidator(ConfirmedPasswordRepeated(view, validationMessage, context!!))
        }
    }

    private fun findValidatedContainerUp(view: View): ValidationContainer? {
        var iteratedView: ViewParent? = view.parent
        while (iteratedView != null) {
            if (iteratedView is ValidationContainer) {
                return iteratedView
            }

            iteratedView = iteratedView.parent
        }

        return null
    }

    @JvmStatic
    @BindingAdapter("validationContext")
    fun setValidationContext(view: View, validationContext: ValidationContext) {
        if (view is ValidationContainer) {
            val validationContainer = view as ValidationContainer
            validationContainer.setValidationContext(validationContext)
        }
    }
}
