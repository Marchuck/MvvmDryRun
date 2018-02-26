package pl.marczak.mvvmdryrun.base.validators

import java.io.InvalidClassException

interface Validator {
    @Throws(InvalidClassException::class)
    fun validate(): Boolean
}