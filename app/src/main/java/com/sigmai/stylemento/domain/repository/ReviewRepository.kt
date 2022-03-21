package com.sigmai.stylemento.domain.repository

import com.sigmai.stylemento.data.model.response.review.Review

interface ReviewRepository {
    fun getReview(email: String) : Review
    fun postReview(reservationSeq: Long, reviewerId: String, reviewerEmail: String, coordinatorId: String, coordinatorEmail: String, star: Int, sex: String, height: String, weight: String, content: String) : Boolean
    fun getReviewReport() : Review
    fun postReviewReport(reservationSeq: Long, reason: String, content: String) : Boolean
}