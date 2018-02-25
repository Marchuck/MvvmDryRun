package pl.marczak.mvvmdryrun.base

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout


class ValidationLinearLayout : LinearLayout, ValidationContainer {

    private var _validationContext: ValidationContext? = null
    private val _idleValidationContext = ValidationContext()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun getValidationContext(): ValidationContext? {
        return if (_validationContext == null) {
            _idleValidationContext
        } else _validationContext

    }

    override fun setValidationContext(context: ValidationContext?) {
        _validationContext = context
        if (_idleValidationContext.validators != null && _idleValidationContext.validators.size > 0) {
            for (validator in _idleValidationContext.validators) {
                _validationContext!!.addValidator(validator)
            }
        }
    }
}
