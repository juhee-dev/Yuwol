package com.yuwol.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MelonChartServiceCreator {
    private const val BASE_URL = "http://3.35.210.102"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val melonChartService: MelonChartService = retrofit.create(MelonChartService::class.java)
}