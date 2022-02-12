package com.sigmai.stylemento.global.base

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.sigmai.stylemento.global.constant.TagType

interface HavingImage {
    var getResult : ActivityResultLauncher<Intent>
    fun getImage(){
        val intent = Intent()
        intent.type = "Image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        getResult.launch(intent)
    }
}