package com.sigmai.stylemento.feature.mypage.dialog

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetFitSelectionBinding
import com.sigmai.stylemento.feature.mypage.MyPageClosetAddFragment
import com.sigmai.stylemento.feature.mypage.MyPageClosetRevisionFragment
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.constant.FitType

class UserClosetFitSelectionDialog(private val f : Fragment) : BaseDialogFragment<DialogFragmentMyPageClosetFitSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_closet_fit_selection
    private var fit : FitType = FitType.NULL

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageClosetFitLooseText.setOnClickListener(View.OnClickListener {
            fit = FitType.LOOSE
            dismiss()
        })
        binding.myPageClosetFitOverText.setOnClickListener(View.OnClickListener {
            fit = FitType.OVER
            dismiss()
        })
        binding.myPageClosetFitSlimText.setOnClickListener(View.OnClickListener {
            fit = FitType.SLIM
            dismiss()
        })
        binding.myPageClosetFitStandardText.setOnClickListener(View.OnClickListener {
            fit = FitType.STANDARD
            dismiss()
        })
    }

    override fun dismiss() {
        super.dismiss()
        when(f){
            is MyPageClosetAddFragment -> f.setFit(fit)
            is MyPageClosetRevisionFragment -> f.setFit(fit)
        }
    }
}