package com.example.architecturesample.module

import com.example.architecturesample.module.authentication.AuthenticationRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    val baseUrl = "https://myapp.com/"

    @Provides
    fun gson(): Gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()


    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    fun authRetrofit(retrofit: Retrofit): AuthenticationRetrofit {
        return retrofit.create(AuthenticationRetrofit::class.java)
    }

}