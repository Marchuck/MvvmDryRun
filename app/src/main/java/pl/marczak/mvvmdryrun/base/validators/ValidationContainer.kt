package pl.marczak.mvvmdryrun.base.validators

interface ValidationContainer {

    fun getValidationContext(): ValidationContext?

    fun setValidationContext(validationContext: ValidationContext?)
}
