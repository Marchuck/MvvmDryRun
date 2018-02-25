package pl.marczak.mvvmdryrun.login

import io.reactivex.Observable

interface LoginRepository {

    fun login(loginRequest: LoginRequest) : Observable<LoginResponse>

}