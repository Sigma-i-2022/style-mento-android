package com.sigmai.stylemento.data.repository.reservation

import com.sigmai.stylemento.data.api.ReservationService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ResvTime
import javax.inject.Inject

class ReservationDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ReservationService>()

    fun client(reserveReq: Client): Boolean {
        return service.client(reserveReq).execute().body()?.success ?: false
    }

    fun clientCancel(clientId: String, reservationSeq: Long, reason: String): Boolean {
        return service.clientCancel(clientId, reservationSeq, reason).execute().body()?.success
            ?: false
    }

    fun clientPay(memberEmail: String, reservationSeq: Long): Boolean {
        return service.clientPay(memberEmail, reservationSeq).execute().body()?.success ?: false
    }

    fun commonAll(): Common {
        return service.commonAll().execute().body()!!.data
    }

    fun commonList(email: String): Boolean {
        return service.commonList(email).execute().body()?.success ?: false
    }

    fun crdiCancel(crdiId: String, reservationSeq: Long, reason: String): Boolean {
        return service.crdiCancel(crdiId, reservationSeq, reason).execute().body()?.success ?: false
    }

    fun crdiFix(clientId: String, reservationSeq: Long, resvTime: ResvTime): Boolean {
        return service.crdiFix(clientId, reservationSeq, resvTime).execute().body()?.success
            ?: false
    }
}