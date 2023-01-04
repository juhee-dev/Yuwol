//package com.yuwol.api
//
//import android.telecom.Call
//import com.yuwol.data.request.RequestProfileData
//import com.yuwol.data.response.ResponseProfileData
//import retrofit2.http.Body
//import retrofit2.http.POST
//
//interface Profile {
//    @POST("/api/member")
//    fun postProfile(
//        @Body body: RequestProfileData
//    ): Call<ResponseProfileData>
//}