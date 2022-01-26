package com.sigmai.stylemento.domain.usecase

import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.domain.entity.Review
import com.sigmai.stylemento.domain.entity.TempCoordinator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCoordinatorListUseCase() {
    private val dummy = listOf(
        TempCoordinator(
            id = 1,
            imageUrl = "https://picsum.photos/199",
            nickname = "algosketch",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.",
            pieceList = listOf(
                Piece(1, "https://picsum.photos/200", "엄청난 작품입니다.", listOf("댄디", "미니멀")),
                Piece(1, "https://picsum.photos/201", "엄청난 작품입니다. 그럼 이만", listOf("미니멀")),
                Piece(1, "https://picsum.photos/202", "엄청난 작품..!!", listOf("댄디"))
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = false,
            numberOfHeart = 13,
            tagList = listOf("미니멀", "댄디")
        ),
        TempCoordinator(
            id = 1,
            imageUrl = "https://picsum.photos/199",
            nickname = "algosketch",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.",
            pieceList = listOf(
                Piece(1, "https://picsum.photos/200", "엄청난 작품입니다.", listOf("댄디", "미니멀")),
                Piece(1, "https://picsum.photos/201", "엄청난 작품입니다. 그럼 이만", listOf("미니멀")),
                Piece(1, "https://picsum.photos/202", "엄청난 작품..!!", listOf("댄디"))
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = false,
            numberOfHeart = 13,
            tagList = listOf("미니멀", "댄디")
        ),
        TempCoordinator(
            id = 1,
            imageUrl = "https://picsum.photos/199",
            nickname = "algosketch",
            email = "algosketch@gmail.com",
            introduction = "개발자입니다.",
            pieceList = listOf(
                Piece(1, "https://picsum.photos/200", "엄청난 작품입니다.", listOf("댄디", "미니멀")),
                Piece(1, "https://picsum.photos/201", "엄청난 작품입니다. 그럼 이만", listOf("미니멀")),
                Piece(1, "https://picsum.photos/202", "엄청난 작품..!!", listOf("댄디"))
            ),
            rating = 4,
            reviewList = listOf(),
            isFavorite = false,
            numberOfHeart = 13,
            tagList = listOf("미니멀", "댄디")
        )
    )

    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        dummy
    }
}