package com.yuwol.api

import com.yuwol.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MelonChartServiceCreator {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val melonChartService: MelonChartService = retrofit.create(MelonChartService::class.java)
}