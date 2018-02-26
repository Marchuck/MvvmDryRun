package pl.marczak.mvvmdryrun.base.validators

class MinLengthParams(val validationMessage: String, val minLength: Int) {


    companion object {

        @JvmStatic
        fun create(validationMessage: String, minLength: Int): MinLengthParams {
            return MinLengthParams(validationMessage, minLength)
        }
    }
}
