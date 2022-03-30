package com.sigmai.stylemento.data.repository.cancelReservation

import com.sigmai.stylemento.data.api.CancelReservationService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.cancel.CancelItem
import javax.inject.Inject

class CancelReservationDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<CancelReservationService>()

    fun postCancelPayment(memberSeq : Long, reservationSeq : Long, paymentKey : String, cancelReason : String, bank : String, accountNumber : String, holderName : String) : Boolean {
        return service.postCancelPayment(memberSeq, reservationSeq, paymentKey, cancelReason, bank, accountNumber, holderName).execute().body()?.success ?: false
    }
    fun getCancelList(memberSeq: Long, page: Int, size: Int): List<CancelItem> {
        return service.getCancelList(memberSeq, page, size).execute().body()!!.data
    }
}