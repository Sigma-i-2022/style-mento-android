package com.sigmai.stylemento.feature.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ActivityMainBinding
import com.sigmai.stylemento.feature.login.LoginHostActivity
import com.sigmai.stylemento.global.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResourceId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val targetIntent = Intent(this, LoginHostActivity::class.java)
        startActivity(targetIntent)
    }

    fun onClickBack(view: View) {
        view.findNavController().navigateUp()
    }
}