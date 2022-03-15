package com.sigmai.stylemento.ui.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ActivityMainBinding
import com.sigmai.stylemento.ui.login.LoginHostActivity
import com.sigmai.stylemento.global.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResourceId = R.layout.activity_main

    private val REQ_CAMERA_PERMISSION = 1001;
    private val REQ_STORAGE_PERMISSION = 1002;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())

        /**
         * LoginActivity 를 띄우려면 이 주석을 제거하세요.
         */
//        val targetIntent = Intent(this, LoginHostActivity::class.java)
//        startActivity(targetIntent)

    }

    fun onClickBack(view: View) {
        view.findNavController().navigateUp()
    }

    fun checkPermission(){
        var cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

        /*if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQ_CAMERA_PERMISSION)
        }*/
        if (readPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQ_STORAGE_PERMISSION)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQ_CAMERA_PERMISSION -> {
                if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    val toast = Toast.makeText(this, "앱 기능 사용을 위한 권한 동의가 필요합니다.", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            REQ_STORAGE_PERMISSION -> {
                if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    val toast = Toast.makeText(this, "앱 기능 사용을 위한 권한 동의가 필요합니다.", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
    }
}