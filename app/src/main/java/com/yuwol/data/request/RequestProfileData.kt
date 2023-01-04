package com.yuwol.data.request

import android.media.Image
import okhttp3.MultipartBody

data class RequestProfileData(

    val username: Long,
    val image: List<MultipartBody.Part?>,
    val introduce: Long

)
