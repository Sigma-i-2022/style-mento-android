package com.sigmai.stylemento.feature.mypage.user.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogFragmentMyPageLookbookBinding
import com.sigmai.stylemento.global.base.BaseDialogFragment

class UserLookbookAddDialog : BaseDialogFragment<DialogFragmentMyPageLookbookBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_lookbook

    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this@UserLookbookAddDialog, 0.8f, 0.7f)
    }
}