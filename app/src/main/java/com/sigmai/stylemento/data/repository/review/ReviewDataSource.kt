package com.sigmai.stylemento.data.repository.review

import com.sigmai.stylemento.data.api.ReviewService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import com.sigmai.stylemento.data.model.response.review.Review
import javax.inject.Inject

class ReviewDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ReviewService>()

    fun getReview(email: String) : Review{
        return service.getReview(email).execute().body()!!.data
    }

    fun postReview(reservationSeq: Long, reviewerId: String, reviewerEmail: String, coordinatorId: String, coordinatorEmail: String, star: Int, sex: String, height: String, weight: String, content: String) : Boolean{
        return service.postReview(reservationSeq, reviewerId, reviewerEmail, coordinatorId, coordinatorEmail, star, sex, height, weight, content).execute().body()?.success ?: false
    }

    fun getReviewReport() : Review{
        return service.getReviewReport().execute().body()!!.data
    }

    fun postReviewReport(reservationSeq: Long, reason: String, content: String) : Boolean{
        return service.postReviewReport(reservationSeq, reason, content).execute().body()?.success ?: false
    }
}