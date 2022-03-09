package com.sigmai.stylemento.data.repository.datasource

import com.sigmai.stylemento.data.model.CoordinatorResponse
import com.sigmai.stylemento.domain.entity.Coordinator
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.util.GlideUtil

class DummyCoordinatorDataSource {
    fun getCoordinatorList() : List<CoordinatorResponse> {
        return dummy
    }

    private val dummy = listOf(
        CoordinatorResponse(
            id = 1,
            imageUrl = GlideUtil.getRandomImageUrl(),
            nickname = "algosketch",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.개발자입니다.",
            pieceList = listOf(
                Piece(1, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(2, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "170", "60", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(3, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "160", "50", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(4, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(5, GlideUtil.getRandomImageUrl(), "엄청난 작품..!!", listOf("댄디"), "2022-01-01", "175", "65", "상의정보", "하의정보", "신발정보", "기타정보", false)
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = false,
            numberOfHeart = 13,
            tagList = listOf("미니멀", "댄디")
        ),
        CoordinatorResponse(
            id = 2,
            imageUrl = GlideUtil.getRandomImageUrl(),
            nickname = "아무말대잔치",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.",
            pieceList = listOf(
                Piece(1, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(2, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "170", "60", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(3, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "160", "50", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(4, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(5, GlideUtil.getRandomImageUrl(), "엄청난 작품..!!", listOf("댄디"), "2022-01-01", "175", "65", "상의정보", "하의정보", "신발정보", "기타정보", false)
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = true,
            numberOfHeart = 13,
            tagList = listOf("댄디")
        ),
        CoordinatorResponse(
            id = 3,
            imageUrl = GlideUtil.getRandomImageUrl(),
            nickname = "HamBP",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.",
            pieceList = listOf(
                Piece(1, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(2, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "170", "60", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(3, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "160", "50", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(4, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(5, GlideUtil.getRandomImageUrl(), "엄청난 작품..!!", listOf("댄디"), "2022-01-01", "175", "65", "상의정보", "하의정보", "신발정보", "기타정보", false)
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = false,
            numberOfHeart = 13,
            tagList = listOf("미니멀", "댄디")
        ),
        CoordinatorResponse(
            id = 4,
            imageUrl = GlideUtil.getRandomImageUrl(),
            nickname = "HamBP",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.",
            pieceList = listOf(
                Piece(1, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(2, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "170", "60", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(3, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "160", "50", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(4, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(5, GlideUtil.getRandomImageUrl(), "엄청난 작품..!!", listOf("댄디"), "2022-01-01", "175", "65", "상의정보", "하의정보", "신발정보", "기타정보", false)
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = false,
            numberOfHeart = 13,
            tagList = listOf("미니멀", "댄디")
        ),
        CoordinatorResponse(
            id = 5,
            imageUrl = GlideUtil.getRandomImageUrl(),
            nickname = "HamBP",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.",
            pieceList = listOf(
                Piece(1, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(2, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "170", "60", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(3, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다.", listOf("댄디", "미니멀"), "2022-01-01", "160", "50", "상의정보", "하의정보", "신발정보", "기타정보", true),
                Piece(4, GlideUtil.getRandomImageUrl(), "엄청난 작품입니다. 그럼 이만", listOf("미니멀"), "2022-01-01", "180", "70", "상의정보", "하의정보", "신발정보", "기타정보", false),
                Piece(5, GlideUtil.getRandomImageUrl(), "엄청난 작품..!!", listOf("댄디"), "2022-01-01", "175", "65", "상의정보", "하의정보", "신발정보", "기타정보", false)
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = false,
            numberOfHeart = 13,
            tagList = listOf("미니멀")
        )
    )
}