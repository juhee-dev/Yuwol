package com.yuwol.model

import com.google.gson.annotations.SerializedName

data class Member (
    @SerializedName("username")
    val username: String,

    @SerializedName("image_url")
    val image_url: String,

    @SerializedName("introduce")
    val introduce: String
)