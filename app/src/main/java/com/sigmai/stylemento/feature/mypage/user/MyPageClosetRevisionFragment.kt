package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.databinding.FragmentMyPageClosetRevisionBinding
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetCategorySelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetFitSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetImageSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetTextureSelectionDialog
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType
import com.sigmai.stylemento.global.util.TransformToStringUtil

class MyPageClosetRevisionFragment(private var closetItem : ClosetItem, private val position: Int) : BaseFragment<FragmentMyPageClosetRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_closet_revision

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextInit()
        setDialogLayout()
        setEditTextLayout()

        binding.myPageClosetRevisionBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })

        binding.myPageClosetRevisionSaveButton.setOnClickListener(View.OnClickListener {
            Client.reviseClosetItem(closetItem, position)
            backToMyPage()
        })
    }
    private fun setTextInit(){
        binding.myPageClosetRevisionCategoryText.text = TransformToStringUtil().getItemCategoryString(closetItem.category)
        binding.myPageClosetRevisionBrandEditText.setText(closetItem.brand)
        binding.myPageClosetRevisionItemNameEditText.setText(closetItem.itemName)
        binding.myPageClosetRevisionTextureText.text = TransformToStringUtil().getTextureString(closetItem.texture)
        binding.myPageClosetRevisionSizeEditText.setText(closetItem.size)
        binding.myPageClosetRevisionFitText.text = TransformToStringUtil().getFitString(closetItem.myFit)
    }
    private fun setDialogLayout(){
        binding.myPageClosetRevisionCategoryButton.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetCategorySelectionDialog(this)
            dialog.show(childFragmentManager, "CategorySelectionDialog")
        })
        binding.myPageClosetRevisionTextureButton.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetTextureSelectionDialog(this)
            dialog.show(childFragmentManager, "TextureSelectionDialog")

        })
        binding.myPageClosetRevisionFitButton.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetFitSelectionDialog(this)
            dialog.show(childFragmentManager, "FitSelectionDialog")
        })

        binding.myPageClosetRevisionItemImg.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })
    }

    private fun setEditTextLayout(){
        binding.myPageClosetRevisionBrandEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                closetItem.brand = p0.toString()
            }
        })
        binding.myPageClosetRevisionItemNameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                closetItem.itemName = p0.toString()
            }
        })
        binding.myPageClosetRevisionSizeEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                closetItem.size = p0.toString()
            }
        })
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment(0))
        transaction.commit()
    }

    fun setCategory(categoryType: ItemCategoryType){
        closetItem.category = categoryType
        binding.myPageClosetRevisionCategoryText.text = TransformToStringUtil().getItemCategoryString(closetItem.category)
    }
    fun setTexture(textureType: TextureType){
        closetItem.texture = textureType
        binding.myPageClosetRevisionTextureText.text = TransformToStringUtil().getTextureString(closetItem.texture)
    }
    fun setFit(fitType: FitType){
        closetItem.myFit = fitType
        binding.myPageClosetRevisionFitText.text = TransformToStringUtil().getFitString(closetItem.myFit)
    }
}