package com.yuwol.model

import com.google.gson.annotations.SerializedName

data class like (
    @SerializedName("like_id")
    val like_id: Long,

    @SerializedName("member_id")
    val member_id: Long,

    @SerializedName("song_id")
    val song_id: Long
        )