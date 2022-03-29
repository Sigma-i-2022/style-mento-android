package com.sigmai.stylemento.domain.usecase.mypage

import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.store.AuthenticationInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPiecesUseCase @Inject constructor() {
    @Inject
    lateinit var lookBookRepository: LookBookRepositoryImpl
    @Inject
    lateinit var workRepository: WorkRepositoryImpl

    suspend operator fun invoke(): List<Piece> {
        return withContext(Dispatchers.IO) {
            if (AuthenticationInformation.userType == AuthenticationInformation.TYPE_CLIENT)
                lookBookRepository.getLookPageAll(AuthenticationInformation.email.value!!).map { Piece.from(it) }
            else workRepository.getCrdiWorkAll(AuthenticationInformation.email.value!!).map { Piece.from(it) }
        }
    }
}