package com.sigmai.stylemento.data.repository.reservation

import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ResvTime
import com.sigmai.stylemento.domain.repository.ReservationRepository
import javax.inject.Inject

class ReservationRepositoryImpl @Inject constructor(private val dataSource: ReservationDataSource) :
    ReservationRepository {
    override fun postReservationClient(reserveReq: Client): Boolean {
        return dataSource.postReservationClient(reserveReq)
    }

    override fun postReservationClientCancel(
        clientId: String,
        reservationSeq: Long,
        reason: String
    ): Boolean {
        return dataSource.postReservationClientCancel(clientId, reservationSeq, reason)
    }

    override fun postReservationClientPay(memberEmail: String, reservationSeq: Long): Boolean {
        return dataSource.postReservationClientPay(memberEmail, reservationSeq)
    }

    override fun getReservationCommonAll(): List<Common> {
        return dataSource.getReservationCommonAll()
    }

    override fun postReservationCommonHide(memberEmail: String, reservationSeq: Long): Boolean {
        return dataSource.postReservationCommonHide(memberEmail, reservationSeq)
    }

    override fun getReservationCommonList(email: String): Boolean {
        return dataSource.getReservationCommonList(email)
    }

    override fun postReservationCrdiCancel(
        crdiId: String,
        reservationSeq: Long,
        reason: String
    ): Boolean {
        return dataSource.postReservationCrdiCancel(crdiId, reservationSeq, reason)
    }

    override fun postReservationCrdiFix(
        clientId: String,
        reservationSeq: Long,
        resvTime: ResvTime
    ): Boolean {
        return dataSource.postReservationCrdiFix(clientId, reservationSeq, resvTime)
    }
}