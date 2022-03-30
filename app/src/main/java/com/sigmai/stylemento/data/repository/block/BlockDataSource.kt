package com.sigmai.stylemento.data.repository.block

import com.sigmai.stylemento.data.api.BlockService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import javax.inject.Inject

class BlockDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<BlockService>()

    fun postBlock(email : String, crdiEmail : String) : Boolean{
        return service.postBlock(email, crdiEmail).execute().body()?.success ?: false
    }
}