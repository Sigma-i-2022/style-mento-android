package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ResvTime

interface ReservationRepository{
    fun postReservationClient(reserveReq: Client): Boolean
    //fun postReservationClientCancel(clientId: String, reservationSeq: Long, reason: String): Boolean
    fun postReservationClientPay(memberEmail: String, reservationSeq: Long): Boolean
    //fun getReservationCommonAll(): List<Common>
    fun postReservationCommonHide(memberEmail: String, reservationSeq: Long) : Boolean
    fun getReservationCommonList(email: String, page: Int, size: Int): List<Common>
    //fun postReservationCrdiCancel(crdiId: String, reservationSeq: Long, reason: String): Boolean
    fun postReservationCrdiFix(crdiId: String, reservationSeq: Long, resvTime: ResvTime): Boolean
}