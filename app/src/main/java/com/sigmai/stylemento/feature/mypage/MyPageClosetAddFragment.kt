package com.sigmai.stylemento.feature.mypage

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.model.Client
import com.sigmai.stylemento.data.model.ClosetItem
import com.sigmai.stylemento.databinding.FragmentMyPageClosetAddBinding
import com.sigmai.stylemento.feature.mypage.dialog.UserClosetCategorySelectionDialog
import com.sigmai.stylemento.feature.mypage.dialog.UserClosetFitSelectionDialog
import com.sigmai.stylemento.feature.mypage.dialog.UserClosetImageSelectionDialog
import com.sigmai.stylemento.feature.mypage.dialog.UserClosetTextureSelectionDialog
import com.sigmai.stylemento.global.base.BaseFragment
import com.sigmai.stylemento.global.constant.FitType
import com.sigmai.stylemento.global.constant.ItemCategoryType
import com.sigmai.stylemento.global.constant.TextureType
import com.sigmai.stylemento.global.util.TransformToEnumUtil
import com.sigmai.stylemento.global.util.TransformToStringUtil

class MyPageClosetAddFragment : BaseFragment<FragmentMyPageClosetAddBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_closet_add

    private var category : ItemCategoryType = ItemCategoryType.NULL
    private var brand : String = ""
    private var itemName : String = ""
    private var texture : TextureType = TextureType.NULL
    private var size : String = ""
    private var myFit : FitType = FitType.NULL

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageClosetAddBackImg.setOnClickListener(View.OnClickListener {
            backToMyPage()
        })
        setDialogLayout()
        setEditTextLayout()

        binding.myPageClosetAddSaveButton.setOnClickListener(View.OnClickListener {
            var closetItem = ClosetItem(Client.getUserName(), "img", category, brand, itemName, texture, size, myFit)
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
    private fun setSpinnerLayout(){
        /*binding.myPageClosetAddCategorySpinner.adapter = context?.let {
            ArrayAdapter.createFromResource(
                it, R.array.itemCategoryList, android.R.layout.simple_spinner_item)
        }
        binding.myPageClosetAddCategorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?,view: View?, position: Int, id: Long) {
                category = TransformToEnumUtil().getItemCategoryType(position)
            }
        }

        binding.myPageClosetAddTextureSpinner.adapter = context?.let {
            ArrayAdapter.createFromResource(
                it, R.array.textureList, android.R.layout.simple_spinner_item)
        }
        binding.myPageClosetAddTextureSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?,view: View?, position: Int, id: Long) {
                texture = TransformToEnumUtil().getTextureType(position)
            }
        }

        binding.myPageClosetAddFitSpinner.adapter = context?.let {
            ArrayAdapter.createFromResource(
                it, R.array.fitList, android.R.layout.simple_spinner_item)
        }
        binding.myPageClosetAddFitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?,view: View?, position: Int, id: Long) {
                myFit = TransformToEnumUtil().getFitType(position)
            }
        }*/
    }
    private fun setEditTextLayout(){
        binding.myPageClosetAddBrandEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                brand = p0.toString()
            }
        })
        binding.myPageClosetAddItemNameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                itemName = p0.toString()
            }
        })
        binding.myPageClosetAddSizeEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                size = p0.toString()
            }
        })
    }

    private fun backToMyPage(){
        val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
        transaction.commit()
    }

    fun setCategory(categoryType: ItemCategoryType){
        category = categoryType
        binding.myPageClosetAddCategoryText.text = TransformToStringUtil().getItemCategoryString(category)
    }
    fun setTexture(textureType: TextureType){
        texture = textureType
        binding.myPageClosetAddTextureText.text = TransformToStringUtil().getTextureString(texture)
    }
    fun setFit(fitType: FitType){
        myFit = fitType
        binding.myPageClosetAddFitText.text = TransformToStringUtil().getFitString(myFit)
    }
}