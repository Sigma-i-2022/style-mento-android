package com.sigmai.stylemento.data.model.response.report

data class Report(
    val createDate: String,
    val memberEmail: String,
    val memberSeq: Long,
    val reportContent: String,
    val reportTitle: String,
    val seq: Long
)