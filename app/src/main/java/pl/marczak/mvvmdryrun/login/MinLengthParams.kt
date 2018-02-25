package pl.marczak.mvvmdryrun.login

import javax.inject.Inject


class MinLengthParams constructor(val validationMessage: String, val minLength: Int) {

    companion object {
        fun create(validationMessage: String, minLength: Int): MinLengthParams {
            return MinLengthParams(validationMessage, minLength)
        }
    }
}