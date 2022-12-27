package com.yuwol.model

data class scrap (
    @SerializedName("scrap_id")
    val scrap_id: Long,

    @SerializedName("member_id")
    val member_id: Long,

    @SerializedName("song_id")
    val song_id: Long
        )