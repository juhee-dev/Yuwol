package com.yuwol.model

import java.io.Serializable

data class Song(
    val cover: Int,
    val rank: String,
    val title: String,
    val artist: String,
    val album: String,
    val date: String,
    val difficulty: String,
    val mood: String,
    val high: String,
    val low: String,
    val rap: String,
    val like: Int,
    val comment: Int,
) : Serializable
