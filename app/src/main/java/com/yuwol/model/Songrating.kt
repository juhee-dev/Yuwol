package com.yuwol.model

data class Songrating (
    @SerializedName("song_id")
    val song_id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("singer")
    val singer: String,

    @SerializedName("image_url")
    val image_url: String,

    @SerializedName("publish_date")
    val publish_date: String,

    @SerializedName("like_count")
    val like_count: Long,

    @SerializedName("scrap_count")
    val scrap_count: Long,

    @SerializedName("comment_count")
    val comment_count: Long,

    @SerializedName("high_difficult")
    val high_difficult: Long,

    @SerializedName("low_difficult")
    val low_difficult: Long,

    @SerializedName("rap_difficult")
    val rap_difficult: Long,

    @SerializedName("mood")
    val mood: Long,

    @SerializedName("evaluate_count")
    val evaluate_count: Long
        )