package com.sigmai.stylemento.data.repository.cancelReservation

import com.sigmai.stylemento.data.api.CancelReservationService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.cancel.CancelItem
import javax.inject.Inject

class CancelReservationDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<CancelReservationService>()

    fun getCancelAll(searchType : String) : List<CancelItem>{
        return service.getCancelAll(searchType).execute().body()!!.data
    }
}