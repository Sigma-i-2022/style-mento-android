package com.sigmai.stylemento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sigmai.stylemento.global.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}