package com.yuwol.api

import com.yuwol.data.request.RequestLoginData
import com.yuwol.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("login/oauth2/client")
    fun postLogin(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>
}