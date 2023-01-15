package com.yuwol.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserInfoServiceCreator {

    private const val BASE_URL = "http://3.35.210.102"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userInfoService: UserInfoService = retrofit.create(UserInfoService::class.java)
}