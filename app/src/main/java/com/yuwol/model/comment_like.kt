package com.yuwol.model

data class comment_like (
    @SerializedName("comment_like")
    val comment_like: Long,

    @SerializedName("member_id")
    val member_id: Long,

    @SerializedName("comment_id")
    val comment_id: Long
        )