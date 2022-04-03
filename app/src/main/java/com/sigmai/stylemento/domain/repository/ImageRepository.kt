package com.sigmai.stylemento.domain.repository

import okhttp3.MultipartBody

interface ImageRepository {
    fun getImage(uuid : String) : String
    fun postImage(imageFile: MultipartBody.Part) : Boolean
}