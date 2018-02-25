package pl.marczak.mvvmdryrun.base

import java.io.InvalidClassException

interface Validator {
    @Throws(InvalidClassException::class)
    fun validate(): Boolean
}