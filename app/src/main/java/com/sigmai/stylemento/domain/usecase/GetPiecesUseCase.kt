package com.sigmai.stylemento.domain.usecase

import com.sigmai.stylemento.data.model.response.lookBook.LookPage
import com.sigmai.stylemento.data.model.response.work.Work
import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.domain.entity.Piece
import com.sigmai.stylemento.global.store.AuthenticationInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
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