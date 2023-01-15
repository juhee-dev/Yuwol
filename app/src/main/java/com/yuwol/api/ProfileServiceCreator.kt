package com.yuwol.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ProfileServiceCreator {
    private const val BASE_URL = "http://3.35.210.102"
    val httpClient = OkHttpClient.Builder()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val profileService: ProfileService = retrofit.create(ProfileService::class.java)
}