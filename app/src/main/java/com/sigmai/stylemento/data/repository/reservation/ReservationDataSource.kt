package com.sigmai.stylemento.data.repository.reservation

import com.sigmai.stylemento.data.api.ReservationService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ResvTime
import javax.inject.Inject

class ReservationDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ReservationService>()

    fun postReservationClient(reserveReq: Client): Boolean {
        return service.postReservationClient(reserveReq).execute().body()?.success ?: false
    }

    fun postReservationClientCancel(clientId: String, reservationSeq: Long, reason: String): Boolean {
        return service.postReservationClientCancel(clientId, reservationSeq, reason).execute().body()?.success
            ?: false
    }

    fun postReservationClientPay(memberEmail: String, reservationSeq: Long): Boolean {
        return service.postReservationClientPay(memberEmail, reservationSeq).execute().body()?.success ?: false
    }

    fun getReservationCommonAll(): List<Common> {
        return service.getReservationCommonAll().execute().body()!!.data
    }

    fun postReservationCommonHide(memberEmail: String, reservationSeq: Long) : Boolean{
        return service.postReservationCommonHide(memberEmail, reservationSeq).execute().body()?.success ?: false
    }

    fun getReservationCommonList(email: String): Boolean {
        return service.getReservationCommonList(email).execute().body()?.success ?: false
    }

    fun postReservationCrdiCancel(crdiId: String, reservationSeq: Long, reason: String): Boolean {
        return service.postReservationCrdiCancel(crdiId, reservationSeq, reason).execute().body()?.success ?: false
    }

    fun postReservationCrdiFix(clientId: String, reservationSeq: Long, resvTime: ResvTime): Boolean {
        return service.postReservationCrdiFix(clientId, reservationSeq, resvTime).execute().body()?.success
            ?: false
    }
}