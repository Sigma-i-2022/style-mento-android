package com.sigmai.stylemento.global.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sigmai.stylemento.R

abstract class BaseActivity<VB: ViewDataBinding> : AppCompatActivity() {
    abstract val layoutResourceId: Int
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
    }
}