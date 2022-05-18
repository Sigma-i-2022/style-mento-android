package com.sigmai.stylemento.domain.usecase.mypage

import com.sigmai.stylemento.data.repository.lookBook.LookBookRepositoryImpl
import com.sigmai.stylemento.data.repository.work.WorkRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeletePieceUseCase @Inject constructor() {
    @Inject
    lateinit var lookBookRepository: LookBookRepositoryImpl
    @Inject
    lateinit var workRepository: WorkRepositoryImpl

    suspend operator fun invoke(id: Long): Boolean {
        return withContext(Dispatchers.IO) {
            if (AuthenticationInfo.userType == AuthenticationInfo.TYPE_CLIENT) lookBookRepository.deleteLookPage(id)
            if (AuthenticationInfo.userType == AuthenticationInfo.TYPE_COORDINATOR) workRepository.deleteCrdiWork(id)
            false
        }
    }
}