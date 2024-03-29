package com.sigmai.stylemento.data.repository.reservation

import com.sigmai.stylemento.data.model.response.reservation.Client
import com.sigmai.stylemento.data.model.response.reservation.Common
import com.sigmai.stylemento.data.model.response.reservation.ReservePartTimeReqs
import com.sigmai.stylemento.domain.repository.ReservationRepository
import javax.inject.Inject

class ReservationRepositoryImpl @Inject constructor(private val dataSource: ReservationDataSource) :
    ReservationRepository {

    override fun getReservationCommon(seq : Long): Common {
        return dataSource.getReservationCommon(seq)
    }

    override fun postReservationClient(reserveReq: Client): Long {
        return dataSource.postReservationClient(reserveReq)
    }

    override fun postReservationClientPay(memberEmail: String, reservationSeq: Long): Boolean {
        return dataSource.postReservationClientPay(memberEmail, reservationSeq)
    }

    override fun postReservationCommonHide(memberEmail: String, reservationSeq: Long): Boolean {
        return dataSource.postReservationCommonHide(memberEmail, reservationSeq)
    }

    override fun getReservationCommonList(email: String, page : Int, size : Int): List<Common> {
        return dataSource.getReservationCommonList(email, page, size)
    }

    override fun postReservationCrdiFix(
        crdiEmail: String,
        reservationSeq: Long,
        resvTime: String
    ): Boolean {
        return dataSource.postReservationCrdiFix(crdiEmail, reservationSeq, resvTime)
    }
}