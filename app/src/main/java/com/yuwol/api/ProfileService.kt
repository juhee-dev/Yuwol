package com.yuwol.api

import android.text.Editable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ProfileService {
    @Multipart
    @POST("/api/member/edit")
    fun postProfile(
        @Header("Authorization") auth: String,
        @Part("username") username: String,
        @Part image: MultipartBody.Part,
        @Part("introduce") introduce: String
    ): Call<ResponseBody>
}