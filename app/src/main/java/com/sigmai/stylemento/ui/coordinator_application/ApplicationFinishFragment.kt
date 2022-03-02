package com.sigmai.stylemento.ui.coordinator_application

import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentApplicationFinishBinding
import com.sigmai.stylemento.global.base.BaseFragment

class ApplicationFinishFragment : BaseFragment<FragmentApplicationFinishBinding>() {
    override val layoutResourceId = R.layout.fragment_application_finish

    override fun initState() {
        binding.returnHomeButton.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_application_finish_to_main)
        }
    }
}