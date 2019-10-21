package com.example.architecturesample.module.authentication

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.POST

interface AuthenticationRetrofit {

    @POST
    fun login(email: String, password: String): Single<Boolean>


}
