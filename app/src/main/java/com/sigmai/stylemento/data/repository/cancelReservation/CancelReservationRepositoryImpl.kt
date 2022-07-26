package com.sigmai.stylemento.data.repository.cancelReservation

import com.sigmai.stylemento.data.model.response.cancel.CancelItem
import com.sigmai.stylemento.domain.repository.CancelReservationRepository
import javax.inject.Inject

class CancelReservationRepositoryImpl @Inject constructor(private val dataSource: CancelReservationDataSource) :
    CancelReservationRepository {
    override fun postCancelPayment(email : String, reservationSeq : Long, paymentKey : String, cancelReason : String, bank : String, accountNumber : String, holderName : String) : Boolean {
        return dataSource.postCancelPayment(email, reservationSeq, paymentKey, cancelReason, bank, accountNumber, holderName)
    }
    override fun getCancelList(memberEmail: String, page: Int, size: Int): List<CancelItem> {
        return dataSource.getCancelList(memberEmail, page, size)
    }
}