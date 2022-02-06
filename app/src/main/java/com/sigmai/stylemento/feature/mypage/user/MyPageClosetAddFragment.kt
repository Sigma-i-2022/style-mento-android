package com.sigmai.stylemento.feature.mypage.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.databinding.FragmentMyPageClosetAddBinding
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetCategorySelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetFitSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetImageSelectionDialog
import com.sigmai.stylemento.feature.mypage.user.dialog.UserClosetTextureSelectionDialog
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType
import com.sigmai.stylemento.global.util.TransformToStringUtil

class MyPageClosetAddFragment : BaseFragment<FragmentMyPageClosetAddBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_closet_add

    private var closetItem : ClosetItem = ClosetItem(Client.getUserInfo().nickname, "", ItemCategoryType.NULL, "", "",
        TextureType.NULL, "", FitType.NULL)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageClosetAddBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })
        setDialogLayout()
        setEditTextLayout()

        binding.myPageClosetAddSaveButton.setOnClickListener(View.OnClickListener {
            Client.addClosetItem(closetItem)
            backToMyPage()
        })
    }
    private fun setDialogLayout(){
        binding.myPageClosetAddCategoryButton.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetCategorySelectionDialog(this)
            dialog.show(childFragmentManager, "CategorySelectionDialog")
        })
        binding.myPageClosetAddTextureButton.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetTextureSelectionDialog(this)
            dialog.show(childFragmentManager, "TextureSelectionDialog")

        })
        binding.myPageClosetAddFitButton.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetFitSelectionDialog(this)
            dialog.show(childFragmentManager, "FitSelectionDialog")
        })

        binding.myPageClosetAddItemImg.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetImageSelectionDialog()
            dialog.show(childFragmentManager, "ImageSelectionDialog")
        })
    }

    private fun setEditTextLayout(){
        binding.myPageClosetAddBrandEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                closetItem.brand = p0.toString()
            }
        })
        binding.myPageClosetAddItemNameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                closetItem.itemName = p0.toString()
            }
        })
        binding.myPageClosetAddSizeEditText.addTextChangedListener(object : TextWatcher {
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
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }

    fun setCategory(categoryType: ItemCategoryType){
        closetItem.category = categoryType
        binding.myPageClosetAddCategoryText.text = TransformToStringUtil().getItemCategoryString(closetItem.category)
    }
    fun setTexture(textureType: TextureType){
        closetItem.texture = textureType
        binding.myPageClosetAddTextureText.text = TransformToStringUtil().getTextureString(closetItem.texture)
    }
    fun setFit(fitType: FitType){
        closetItem.myFit = fitType
        binding.myPageClosetAddFitText.text = TransformToStringUtil().getFitString(closetItem.myFit)
    }
}