package com.sigmai.stylemento.ui.login

import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ActivityLoginHostBinding
import com.sigmai.stylemento.global.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginHostActivity : BaseActivity<ActivityLoginHostBinding>() {
    override val layoutResourceId = R.layout.activity_login_host
}