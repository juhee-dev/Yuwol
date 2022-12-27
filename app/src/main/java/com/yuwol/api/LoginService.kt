package com.yuwol.api

import retrofit2.http.GET

interface LoginService {
    @GET("/login/oauth2/<social>?code=<code>")
    fun getLogin(

    )
}