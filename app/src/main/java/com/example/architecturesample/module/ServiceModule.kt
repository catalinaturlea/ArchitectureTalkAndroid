package com.example.architecturesample.module

import com.example.architecturesample.AuthenticationService
import com.example.architecturesample.IAuthenticationService
import com.example.architecturesample.module.authentication.AuthenticationRetrofit
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun authenticationService(authRetrofit: AuthenticationRetrofit): IAuthenticationService {
        return AuthenticationService(authRetrofit)
    }
}