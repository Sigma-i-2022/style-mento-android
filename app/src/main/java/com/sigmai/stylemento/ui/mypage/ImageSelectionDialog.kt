package com.sigmai.stylemento.ui.mypage

import android.os.Bundle
import android.view.*
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogImageSelectionBinding
import com.sigmai.stylemento.ui.mypage.user.MyPageUserRevisionFragment
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.base.HavingImage

class ImageSelectionDialog(private val f : HavingImage) : BaseDialogFragment<DialogImageSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_image_selection

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgSelectionCameraImg.setOnClickListener(View.OnClickListener {
            context?.let { it1 -> f.getImageFromCamera(it1) }
            dismiss()
        })
        binding.imgSelectionAlbumSelectionImg.setOnClickListener(View.OnClickListener {
            context?.let { it1 -> f.getImageFromGallery(it1) }
            dismiss()
        })
    }
}