package com.yuwol.data.response

import com.yuwol.model.Member

data class ResponseLoginData(
    val accessToken: String,
    val refreshToken: String,
    val member: Member
)