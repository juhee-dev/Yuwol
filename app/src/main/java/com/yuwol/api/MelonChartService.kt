package com.yuwol.api

import com.yuwol.data.response.ResponseMelonChartData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MelonChartService {
    @GET("api/chart/mellon?page=1&size=100")
    fun getMellonChart(
        @Header("Authorization") auth: String
    ): Call<ResponseMelonChartData>
}