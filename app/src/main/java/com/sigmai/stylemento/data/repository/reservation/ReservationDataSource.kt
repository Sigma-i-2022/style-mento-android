package com.sigmai.stylemento.data.repository.reservation

import com.sigmai.stylemento.data.api.ReservationService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ResvTime
import javax.inject.Inject

class ReservationDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ReservationService>()


    fun getReservationCommon(seq: Long): Common {
        return service.getReservationCommon(seq).execute().body()!!.data
    }

    fun postReservationClient(reserveReq: Client): Boolean {
        return service.postReservationClient(reserveReq).execute().body()?.success ?: false
    }


    fun postReservationClientPay(memberEmail: String, reservationSeq: Long): Boolean {
        return service.postReservationClientPay(memberEmail, reservationSeq).execute().body()?.success ?: false
    }

    fun postReservationCommonHide(memberEmail: String, reservationSeq: Long) : Boolean{
        return service.postReservationCommonHide(memberEmail, reservationSeq).execute().body()?.success ?: false
    }

    fun getReservationCommonList(email: String, page: Int, size: Int): List<Common> {
        return service.getReservationCommonList(email, page, size).execute().body()!!.data
    }

    fun postReservationCrdiFix(crdiId: String, reservationSeq: Long, resvTime: ResvTime): Boolean {
        return service.postReservationCrdiFix(crdiId, reservationSeq, resvTime).execute().body()?.success
            ?: false
    }
}