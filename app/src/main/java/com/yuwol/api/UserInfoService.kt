package com.yuwol.api

import com.yuwol.data.request.RequestLoginData
import com.yuwol.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface UserInfoService {
    @GET("api/member")
    fun postLogin(

    ): Call<ResponseLoginData>
}