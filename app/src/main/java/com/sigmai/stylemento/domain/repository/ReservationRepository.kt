package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ResvTime

interface ReservationRepository{
    fun getReservationCommon(seq: Long): Common
    fun postReservationClient(reserveReq: Client): Boolean
    fun postReservationClientPay(memberEmail: String, reservationSeq: Long): Boolean
    fun postReservationCommonHide(memberEmail: String, reservationSeq: Long) : Boolean
    fun getReservationCommonList(email: String, page: Int, size: Int): List<Common>
    fun postReservationCrdiFix(crdiId: String, reservationSeq: Long, resvTime: ResvTime): Boolean
}