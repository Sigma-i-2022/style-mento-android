package com.sigmai.stylemento.feature.mypage.user.dialog

import android.os.Bundle
import android.view.*
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogFragmentMyPageUserImageSelectionBinding
import com.sigmai.stylemento.global.base.BaseDialogFragment

class UserImageSelectionDialog : BaseDialogFragment<DialogFragmentMyPageUserImageSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_user_image_selection

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