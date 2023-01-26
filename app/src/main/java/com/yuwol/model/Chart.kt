package com.yuwol.model

import java.io.Serializable

data class Chart(
    val cover: Int,
    val rank: String,
    val title: String,
    val artist: String,
    val difficulty: String,
    val mood: String,
    val high: String,
    val low: String,
    val rap: String,
) : Serializable

