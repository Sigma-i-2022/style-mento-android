package com.sigmai.stylemento.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.ViewPrivacyDialogBinding
import com.sigmai.stylemento.global.base.BaseDialogFragment

class PrivacyDialogFragment : BaseDialogFragment<ViewPrivacyDialogBinding>() {
    override val layoutResourceId = R.layout.view_privacy_dialog
    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this@PrivacyDialogFragment, 0.8f, 0.8f)
    }
}