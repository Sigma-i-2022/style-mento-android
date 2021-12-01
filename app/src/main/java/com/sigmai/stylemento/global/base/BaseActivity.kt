package com.sigmai.stylemento.global.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sigmai.stylemento.R

abstract class BaseActivity : AppCompatActivity() {
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}