package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.cancel.CancelItem

interface CancelReservationRepository {
    fun postCancelPayment(email : String, reservationSeq : Long, paymentKey : String, cancelReason : String, bank : String, accountNumber : String, holderName : String) : Boolean
    fun getCancelList(memberEmail : String, page : Int, size : Int) : List<CancelItem>
}