package com.sigmai.stylemento.feature.mypage.dialog

import android.os.Bundle
import android.view.*
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetBinding
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.util.TransformToStringUtil

class UserClosetItemDialog(private val item : ClosetItem) : BaseDialogFragment<DialogFragmentMyPageClosetBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_closet

    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this@UserClosetItemDialog, 0.8f, 0.7f)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageClosetDialogCategoryText.text = TransformToStringUtil().getItemCategoryString(item.category)
        binding.myPageClosetDialogBrandText.text = item.brand
        binding.myPageClosetDialogItemNameText.text = item.itemName
        binding.myPageClosetDialogTextureText.text = TransformToStringUtil().getTextureString(item.texture)
        binding.myPageClosetDialogSizeText.text = item.size
        binding.myPageClosetDialogFitText.text = TransformToStringUtil().getFitString(item.myFit)
    }

}