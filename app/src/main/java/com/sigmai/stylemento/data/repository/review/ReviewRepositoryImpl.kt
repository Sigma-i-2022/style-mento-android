package com.sigmai.stylemento.data.repository.review

import com.sigmai.stylemento.data.model.response.review.Review
import com.sigmai.stylemento.domain.repository.ReviewRepository
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(private val dataSource: ReviewDataSource) :
    ReviewRepository {
    override fun getReview(email: String): Review {
        return dataSource.getReview(email)
    }
    override fun postReview(
        reservationSeq: Long,
        reviewerId: String,
        reviewerEmail: String,
        coordinatorId: String,
        coordinatorEmail: String,
        star: Int,
        sex: String,
        height: String,
        weight: String,
        content: String
    ): Boolean {
        return dataSource.postReview(reservationSeq, reviewerId, reviewerEmail, coordinatorId, coordinatorEmail, star, sex, height, weight, content)
    }

    override fun getReviewReport(): Review {
        return dataSource.getReviewReport()
    }
    override fun postReviewReport(reservationSeq: Long, reason: String, content: String): Boolean {
        return dataSource.postReviewReport(reservationSeq, reason, content)
    }
}