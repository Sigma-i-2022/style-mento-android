package com.sigmai.stylemento.data.repository.report

import com.sigmai.stylemento.data.api.ReportService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.report.Report
import javax.inject.Inject

class ReportDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ReportService>()

    fun postReport(memberSeq: Long, memberEmail: String, reportTitle: String, reportContent: String) : Boolean{
        return service.postReport(memberSeq, memberEmail, reportTitle, reportContent).execute().body()?.success ?: false
    }

    fun getReportAll() : List<Report>{
        return service.getReportAll().execute().body()!!.data
    }

    fun getReportMember(memberSeq: Long) : Report{
        return service.getReportMember(memberSeq).execute().body()!!.data
    }
}