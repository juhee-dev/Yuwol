package com.yuwol.model

import com.google.gson.annotations.SerializedName

data class evaluation (
    @SerializedName("evaluation_id")
    val evaluation_id: Long,

    @SerializedName("member_id")
    val member_id: Long,

    @SerializedName("song_id")
    val song_id: Long,

    @SerializedName("comment_id")
    val comment_id: Long,

    @SerializedName("high_difficult")
    val high_difficult: Long,

    @SerializedName("low_difficult")
    val low_difficult: Long,

    @SerializedName("rap_difficult")
    val rap_difficult: Long,

    @SerializedName("mood")
    val mood: Long

        )