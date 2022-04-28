package com.sigmai.stylemento.global.util

import android.app.Activity
import android.content.Context
import androidx.activity.result.ActivityResult
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import java.io.File

class MultipartUtil {
    fun getMultipartBody(result: ActivityResult, context: Context) : MultipartBody.Part? {
        if (result.resultCode == Activity.RESULT_OK) {
            try {
                val uri = result.data?.data ?: return null
                val filePath = PathUtil().getPath(context, uri)
                val file = File(filePath!!)
                val stream = context.contentResolver?.openInputStream(uri)
                val requestFile = stream!!.asRequestBody("multipart/form-data".toMediaType())

                return MultipartBody.Part.createFormData("imageFile", file.name, requestFile)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return null
    }
}