package com.sigmai.stylemento.feature.mypage.dialog

import android.os.Bundle
import android.view.*
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetTextureSelectionBinding
import com.sigmai.stylemento.feature.mypage.MyPageClosetAddFragment
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.constant.TextureType

class UserClosetTextureSelectionDialog(private val f : MyPageClosetAddFragment) : BaseDialogFragment<DialogFragmentMyPageClosetTextureSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_closet_texture_selection
    private var texture : TextureType = TextureType.NULL
    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myPageClosetAngoraText.setOnClickListener(View.OnClickListener {
            texture = TextureType.ANGORA
            dismiss()
        })
        binding.myPageClosetCategoryAcrylText.setOnClickListener(View.OnClickListener {
            texture = TextureType.ACRYL
            dismiss()
        })
        binding.myPageClosetCategoryBokashiText.setOnClickListener(View.OnClickListener {
            texture = TextureType.BOKASHI
            dismiss()
        })
        binding.myPageClosetCategoryBuntoText.setOnClickListener(View.OnClickListener {
            texture = TextureType.BUNTO
            dismiss()
        })
        binding.myPageClosetCategoryCottonText.setOnClickListener(View.OnClickListener {
            texture = TextureType.COTTON
            dismiss()
        })
        binding.myPageClosetCategoryDenimText.setOnClickListener(View.OnClickListener {
            texture = TextureType.DENIM
            dismiss()
        })
        binding.myPageClosetCategoryJacquardText.setOnClickListener(View.OnClickListener {
            texture = TextureType.JACQUARD
            dismiss()
        })
        binding.myPageClosetCategoryLeatherText.setOnClickListener(View.OnClickListener {
            texture = TextureType.LEATHER
            dismiss()
        })
        binding.myPageClosetCategoryLinenText.setOnClickListener(View.OnClickListener {
            texture = TextureType.LINEN
            dismiss()
        })
        binding.myPageClosetCategoryOxfordText.setOnClickListener(View.OnClickListener {
            texture = TextureType.OXFORD
            dismiss()
        })
        binding.myPageClosetCategoryPolyesterText.setOnClickListener(View.OnClickListener {
            texture = TextureType.POLYESTER
            dismiss()
        })
        binding.myPageClosetCategoryRaisedText.setOnClickListener(View.OnClickListener {
            texture = TextureType.RAISED
            dismiss()
        })
        binding.myPageClosetCategoryRayonText.setOnClickListener(View.OnClickListener {
            texture = TextureType.RAYON
            dismiss()
        })
        binding.myPageClosetCategorySilkText.setOnClickListener(View.OnClickListener {
            texture = TextureType.SLIK
            dismiss()
        })
        binding.myPageClosetCategorySilketText.setOnClickListener(View.OnClickListener {
            texture = TextureType.SILKET
            dismiss()
        })
        binding.myPageClosetCategorySuedeText.setOnClickListener(View.OnClickListener {
            texture = TextureType.SUEDE
            dismiss()
        })
        binding.myPageClosetCategoryTencelText.setOnClickListener(View.OnClickListener {
            texture = TextureType.TENCEL
            dismiss()
        })
        binding.myPageClosetCategoryTerryText.setOnClickListener(View.OnClickListener {
            texture = TextureType.TERRY
            dismiss()
        })
        binding.myPageClosetCategoryTweedText.setOnClickListener(View.OnClickListener {
            texture = TextureType.TWEED
            dismiss()
        })
        binding.myPageClosetCategoryWoolText.setOnClickListener(View.OnClickListener {
            texture = TextureType.WOOL
            dismiss()
        })
        binding.myPageClosetChiffonText.setOnClickListener(View.OnClickListener {
            texture = TextureType.CHIFFON
            dismiss()
        })
        binding.myPageClosetCoduroyText.setOnClickListener(View.OnClickListener {
            texture = TextureType.CODUROY
            dismiss()
        })
        binding.myPageClosetFurText.setOnClickListener(View.OnClickListener {
            texture = TextureType.FUR
            dismiss()
        })
        binding.myPageClosetLaceText.setOnClickListener(View.OnClickListener {
            texture = TextureType.LACE
            dismiss()
        })
        binding.myPageClosetNylonText.setOnClickListener(View.OnClickListener {
            texture = TextureType.NYLON
            dismiss()
        })
    }

    override fun dismiss() {
        super.dismiss()
        f.setTexture(texture)
    }
}