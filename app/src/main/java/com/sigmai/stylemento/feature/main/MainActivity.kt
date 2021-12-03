package com.sigmai.stylemento.feature.main

import android.content.Intent
import android.os.Bundle
import com.sigmai.stylemento.R
import com.sigmai.stylemento.feature.login.LoginHostActivity
import com.sigmai.stylemento.global.base.BaseActivity

class MainActivity : BaseActivity() {
    override val layoutResourceId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val targetIntent = Intent(this, LoginHostActivity::class.java)
        startActivity(targetIntent)
    }
}