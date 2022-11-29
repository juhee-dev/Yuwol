package com.yuwol.model

import java.io.Serializable

data class Rate(
    val cover: Int,
    val rank: String,
    val title: String,
    val artist: String,
) : Serializable
