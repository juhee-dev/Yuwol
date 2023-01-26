package com.yuwol.model

import com.google.gson.annotations.SerializedName

data class Comment (
//    @SerializedName("comment_id")
//    val comment_id: Long,
//
//    @SerializedName("member_id")
//    val member_id: Long,
//
//    @SerializedName("song_id")
//    val song_id: Long,
//
//    @SerializedName("like_count")
//    val like_count: Long

    val image: String,
    val name: String,
    val comment: String,
    val date: String,
    val like: Int,
    val dislike: Int
)