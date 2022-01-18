package com.sigmai.stylemento.feature.mypage.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetBinding
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetCategorySelectionBinding
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetCategorySelectionBindingImpl
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetFitSelectionBinding
import com.sigmai.stylemento.global.base.BaseDialogFragment

class UserClosetFitSelectionDialog : BaseDialogFragment<DialogFragmentMyPageClosetFitSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_closet_fit_selection

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}