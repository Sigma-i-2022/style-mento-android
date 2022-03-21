package com.sigmai.stylemento.data.repository.cancelReservation

import com.sigmai.stylemento.data.model.response.cancel.CancelItem
import com.sigmai.stylemento.domain.repository.CancelReservationRepository
import javax.inject.Inject

class CancelReservationRepositoryImpl @Inject constructor(private val dataSource: CancelReservationDataSource) :
    CancelReservationRepository {
    override fun getCancelAll(searchType: String): List<CancelItem> {
        return dataSource.getCancelAll(searchType)
    }
}