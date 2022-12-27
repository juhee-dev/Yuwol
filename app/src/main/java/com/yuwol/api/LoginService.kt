package com.yuwol.api

import com.yuwol.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.http.GET

interface LoginService {
    val social: String
    val code: String
    @GET("/login/oauth2/<social>?code=<code>")
    fun getLogin(): Call<ResponseLoginData>
}