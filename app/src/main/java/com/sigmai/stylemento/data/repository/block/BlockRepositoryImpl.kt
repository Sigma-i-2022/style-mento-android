package com.sigmai.stylemento.data.repository.block

import com.sigmai.stylemento.domain.repository.BlockRepository
import javax.inject.Inject

class BlockRepositoryImpl @Inject constructor(private val dataSource: BlockDataSource) : BlockRepository {

    override fun postBlock(email : String, crdiEmail : String) : Boolean{
        return dataSource.postBlock(email, crdiEmail)
    }
}