package com.sigmai.stylemento.data.repository.cancelReservation

import com.sigmai.stylemento.data.api.CancelReservationService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.cancel.CancelItem
import javax.inject.Inject

class CancelReservationDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<CancelReservationService>()

    fun postCancelPayment(email : String, reservationSeq : Long, paymentKey : String, cancelReason : String, bank : String, accountNumber : String, holderName : String) : Boolean {
        return service.postCancelPayment(email, reservationSeq, paymentKey, cancelReason, bank, accountNumber, holderName).execute().body()?.success ?: false
    }
    fun getCancelList(memberEmail: String, page: Int, size: Int): List<CancelItem> {
        return service.getCancelList(memberEmail, page, size).execute().body()!!.data
    }
}