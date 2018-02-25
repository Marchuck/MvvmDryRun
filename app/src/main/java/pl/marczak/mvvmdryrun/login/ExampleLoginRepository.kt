package pl.marczak.mvvmdryrun.login

import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ExampleLoginRepository @Inject constructor() : LoginRepository {

    override fun login(loginRequest: LoginRequest): Observable<LoginResponse> {
        return Observable
                .fromCallable { LoginResponse(200, UUID.randomUUID().toString()) }
                .delay(300, TimeUnit.MILLISECONDS)
    }
}