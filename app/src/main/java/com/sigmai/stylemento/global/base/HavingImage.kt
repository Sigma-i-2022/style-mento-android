package com.sigmai.stylemento.global.base

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Environment
import android.provider.MediaStore
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.sigmai.stylemento.global.constant.TagType
import java.io.File

interface HavingImage {
    var getResult: ActivityResultLauncher<Intent>
    fun getImageFromCamera(context: Context) {
        var permission = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
        if (permission == PackageManager.PERMISSION_DENIED) {  //권한 없어서 요청
            var state = Environment.getExternalStorageState()
            if (TextUtils.equals(state, Environment.MEDIA_MOUNTED)) {
                var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                getResult.launch(intent)
            }
        }
        else {
            val toast = Toast.makeText(context, "사용자의 권한 동의가 필요한 기능입니다.", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun getImageFromGallery(context: Context) {
        var readPermission =
            ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (readPermission == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent()
            intent.type = "Image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            getResult.launch(intent)
        }
        else {
            val toast = Toast.makeText(context, "사용자의 권한 동의가 필요한 기능입니다.", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}