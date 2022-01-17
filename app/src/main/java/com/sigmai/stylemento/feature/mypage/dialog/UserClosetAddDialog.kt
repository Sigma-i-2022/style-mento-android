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
import com.sigmai.stylemento.global.base.BaseDialogFragment

class UserClosetAddDialog : BaseDialogFragment<DialogFragmentMyPageClosetBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_closet

    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this@UserClosetAddDialog, 0.8f, 0.7f)
    }


}