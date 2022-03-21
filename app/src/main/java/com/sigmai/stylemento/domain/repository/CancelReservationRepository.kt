package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.cancel.CancelItem

interface CancelReservationRepository {
    fun getCancelAll(searchType : String) : List<CancelItem>
}