package com.sigmai.stylemento.feature.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.base.BaseFragment

class Navigation : BaseFragment() {
    override val layoutResourceId = R.layout.fragment_navigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        view?.findViewById<Button>(R.id.btn_signup)?.setOnClickListener {
            this.findNavController().navigate(R.id.action_navigation_to_signup)
        }

        view?.findViewById<Button>(R.id.btn_home)?.setOnClickListener {
            this.findNavController().navigate(R.id.action_navigation_to_home)
        }

        return view
    }
}