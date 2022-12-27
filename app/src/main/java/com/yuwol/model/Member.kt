package com.yuwol.model

import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("member_id")
    val member_id: Long,

    @SerializedName("email")
    val email: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("image_url")
    val image_url: String,

    @SerializedName("introduce")
    val introduce: String,
)
