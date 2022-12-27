package com.yuwol.`interface`

import com.yuwol.model.Member
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("api/member")
    fun getUser(): Call<Member>
}