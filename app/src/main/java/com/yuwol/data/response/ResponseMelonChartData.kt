package com.yuwol.data.response

data class ResponseMelonChartData(
    val songld: String,
    val title: String,
    val singer: String,
    val imageUrl: String,
    val totalDifficult: String,
    val rapDifficult: String,
    val highDifficult: String,
    val lowDifficult: String,
    var mood: String,
    var isMySinglist: String
)
