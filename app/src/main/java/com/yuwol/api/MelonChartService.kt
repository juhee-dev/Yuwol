package com.yuwol.api

import com.yuwol.data.response.ResponseMelonChartData
import retrofit2.Call
import retrofit2.http.GET

interface MelonChartService {
    @GET("api/chart/mellon")
    fun getMelonChart(): Call<ResponseMelonChartData>
}