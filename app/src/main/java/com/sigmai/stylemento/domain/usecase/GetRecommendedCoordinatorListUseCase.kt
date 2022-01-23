package com.sigmai.stylemento.domain.usecase

import com.sigmai.stylemento.data.model.RecommendedCoordinator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRecommendedCoordinatorListUseCase {
    val dummyData = listOf(
        RecommendedCoordinator("algosketch",
            listOf("#미니멀", "#캐주얼", "댄디")),
        RecommendedCoordinator("hambp",
            listOf("#모던", "캐주얼")),
        RecommendedCoordinator("jenny_eqet",
            listOf("#스트릿", "#캐주얼"))
    )

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        dummyData
    }
}