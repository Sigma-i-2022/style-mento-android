package com.sigmai.stylemento.data.repository.image

import com.sigmai.stylemento.data.api.ImageService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<ImageService>()
    fun getImage(uuid : String) : String{
        return service.getImage(uuid).execute().body()?.data!!

    }
    fun postImage(imageFile: MultipartBody.Part) : String {
        return service.postImage(imageFile).execute().body()?.data!!
    }
}