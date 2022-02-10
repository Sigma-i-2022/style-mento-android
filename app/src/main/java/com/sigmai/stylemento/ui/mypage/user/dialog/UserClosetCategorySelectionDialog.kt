package com.sigmai.stylemento.ui.mypage.user.dialog

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetCategorySelectionBinding
import com.sigmai.stylemento.ui.mypage.user.MyPageClosetAddFragment
import com.sigmai.stylemento.ui.mypage.user.MyPageClosetRevisionFragment
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.constant.ItemCategoryType

class UserClosetCategorySelectionDialog(private val f : Fragment) : BaseDialogFragment<DialogFragmentMyPageClosetCategorySelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_closet_category_selection

    private var category : ItemCategoryType = ItemCategoryType.NULL
    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageClosetCategoryTopText.setOnClickListener(View.OnClickListener {
            category = ItemCategoryType.TOP
            dismiss()
        })
        binding.myPageClosetCategoryPantsText.setOnClickListener(View.OnClickListener {
            category = ItemCategoryType.PANTS
            dismiss()
        })
        binding.myPageClosetCategoryShoesText.setOnClickListener(View.OnClickListener {
            category = ItemCategoryType.SHOES
            dismiss()
        })
    }

    override fun dismiss() {
        super.dismiss()
        when(f){
            is MyPageClosetAddFragment -> f.setCategory(category)
            is MyPageClosetRevisionFragment -> f.setCategory(category)
        }
    }
}