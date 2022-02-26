package com.sigmai.stylemento.domain.entity

import com.sigmai.stylemento.data.model.CoordinatorResponse

data class Coordinator(
    val id: Long,
    val imageUrl: String?,
    val nickname: String,
    val email: String?,
    val introduction: String,
    val pieceList: List<Piece>,
    val rating: Int,
    val reviewList: List<Review>?,
    val numberOfHeart: Int,
    val tagList: List<String>
) {
    fun from(coordinatorResponse: CoordinatorResponse) : Coordinator {
        /** isFavorite 은 관심 코디네이터인데 MVP 변경으로 인해 현재 필요 없음. 하지만 서버에서는 Response 로 줄 가능성이 있음.
         * 따라서 data 레이어의 CoordinatorResponse 에 변화가 생겨도 이것을 domain 레이어의 Coordinator 로 변형시켜서 사용하면
         * domain 레이어에서는 이 파일을 제외하고 다른 코드를 수정하지 않아도 된다.
         */
        return Coordinator(
            id = coordinatorResponse.id,
            imageUrl = coordinatorResponse.imageUrl,
            nickname = coordinatorResponse.nickname,
            email = coordinatorResponse.email,
            introduction = coordinatorResponse.introduction,
            pieceList = coordinatorResponse.pieceList,
            rating = coordinatorResponse.rating,
            reviewList = coordinatorResponse.reviewList,
            numberOfHeart = coordinatorResponse.numberOfHeart,
            tagList = coordinatorResponse.tagList
        )
    }
}