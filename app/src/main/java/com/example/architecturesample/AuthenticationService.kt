package com.example.architecturesample

import com.example.architecturesample.module.authentication.AuthenticationRetrofit
import io.reactivex.Single


interface IAuthenticationService {

}

class AuthenticationService(val authRetrofit: AuthenticationRetrofit): IAuthenticationService {

    fun login(email: String, password: String): Single<Boolean> {
        return authRetrofit.login(email, password)
    }
}