package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.report.Report

interface ReportRepository {
    fun postReport(memberSeq: Long, memberEmail: String, reportTitle: String, reportContent: String) : Boolean
    fun getReportAll() : List<Report>
    fun getReportMember(memberSeq: Long) : Report
}