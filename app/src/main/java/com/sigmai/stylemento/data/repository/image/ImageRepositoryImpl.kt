package com.sigmai.stylemento.data.repository.image

import com.sigmai.stylemento.domain.repository.ImageRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(private val dataSource : ImageDataSource) : ImageRepository{
    override fun getImage(uuid : String) : String{
        return dataSource.getImage(uuid)
    }
    override fun postImage(imageFile: MultipartBody.Part) : Boolean{
        return dataSource.postImage(imageFile)
    }
}