package com.sigmai.stylemento.data.repository.reservation

import com.sigmai.stylemento.domain.repository.ReservationRepository
import javax.inject.Inject

class ReservationRepositoryImpl @Inject constructor(private val dataSource: ReservationDataSource) :
    ReservationRepository