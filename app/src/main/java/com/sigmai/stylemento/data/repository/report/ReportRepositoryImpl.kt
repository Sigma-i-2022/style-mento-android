package com.sigmai.stylemento.data.repository.report

import com.sigmai.stylemento.data.model.response.report.Report
import com.sigmai.stylemento.domain.repository.ReportRepository
import javax.inject.Inject

class ReportRepositoryImpl @Inject constructor(private val dataSource: ReportDataSource) :
    ReportRepository {
    override fun postReport(
        memberSeq: Long,
        memberEmail: String,
        reportTitle: String,
        reportContent: String
    ): Boolean {
        return dataSource.postReport(memberSeq, memberEmail, reportTitle, reportContent)
    }

    override fun getReportAll(): List<Report> {
        return dataSource.getReportAll()
    }

    override fun getReportMember(memberSeq: Long): Report {
        return dataSource.getReportMember(memberSeq)
    }
}