package com.sigmai.stylemento.feature.mypage.dialog

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogFragmentMyPageClosetTextureSelectionBinding
import com.sigmai.stylemento.databinding.DialogFragmentMyPageLookbookTagSelectionBinding
import com.sigmai.stylemento.feature.mypage.MyPageClosetAddFragment
import com.sigmai.stylemento.feature.mypage.MyPageClosetRevisionFragment
import com.sigmai.stylemento.feature.mypage.MyPageLookbookAddFragment
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.constant.TextureType
import com.sigmai.stylemento.global.util.TransformToIntUtil

class UserLookbookTagSelectionDialog(private val f: Fragment) :
    BaseDialogFragment<DialogFragmentMyPageLookbookTagSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_fragment_my_page_lookbook_tag_selection
    private var tags: MutableList<TagType> = mutableListOf()
    private var tagStates: Array<Boolean> = Array(24) { false }
    private var onTagNumber: Int = 0
    private val intUtil = TransformToIntUtil()

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageLookbookTagSaveButton.setOnClickListener(View.OnClickListener {
            when (f) {
                is MyPageLookbookAddFragment -> f.setTags(tags)
            }
        })

        binding.myPageLookbookTagCasulalText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagCasulalText, TagType.CASULAL)
        })
        binding.myPageLookbookTagStreetText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagStreetText, TagType.STREET)
        })
        binding.myPageLookbookTagModernText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagModernText, TagType.MODERN)
        })
        binding.myPageLookbookTagFeminineText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagFeminineText, TagType.FEMININE)
        })
        binding.myPageLookbookTagDandyText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagDandyText, TagType.DANDY)
        })
        binding.myPageLookbookTagMinimalText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagMinimalText, TagType.MINIMAL)
        })
        binding.myPageLookbookTagMaximalText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagMaximalText, TagType.MAXIMAL)
        })
        binding.myPageLookbookTagCityText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagCityText, TagType.CITY)
        })
        binding.myPageLookbookTagAmericanCasualText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagAmericanCasualText, TagType.AMERICANCASUAL)
        })
        binding.myPageLookbookTagClassicText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagClassicText, TagType.CLASSIC)
        })
        binding.myPageLookbookTagStudentText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagStudentText, TagType.STUDENT)
        })
        binding.myPageLookbookTagOfficeText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagOfficeText, TagType.OFFICE)
        })
        binding.myPageLookbookTagDateText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagDateText, TagType.DATE)
        })
        binding.myPageLookbookTagBlindDateText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagBlindDateText, TagType.BLINDDATE)
        })
        binding.myPageLookbookTagTourText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagStudentText, TagType.TRAVEL)
        })
        binding.myPageLookbookTagPartyText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagPartyText, TagType.PARTY)
        })
        binding.myPageLookbookTagCoupleText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagCoupleText, TagType.COUPLE)
        })
        binding.myPageLookbookTagGuestText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagGuestText, TagType.GUEST)
        })
        binding.myPageLookbookTagSpringText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagSpringText, TagType.SPRING)
        })
        binding.myPageLookbookTagSummerText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagSummerText, TagType.SUMMER)
        })
        binding.myPageLookbookTagAutumnText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagAutumnText, TagType.AUTUMN)
        })
        binding.myPageLookbookTagWinterText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagWinterText, TagType.WINTER)
        })
        binding.myPageLookbookTagRainText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.myPageLookbookTagRainText, TagType.RAIN)
        })
    }

    private fun onTextViewClick(textView: TextView, tagType: TagType) {

        var state = !tagStates[intUtil.getTagInt(tagType)]
        if (state && onTagNumber < 4) {
            tags.add(tagType)
            onTagNumber++
        }
        if (!state) {
            if (removeTag(tagType))
                onTagNumber--
        }
        else
            return

        tagStates[intUtil.getTagInt(tagType)] = state

        if(state)
            textView.setBackgroundResource(R.drawable.button_round_click)
        else
            textView.setBackgroundResource(R.drawable.button_round)
    }

    private fun removeTag(tagType: TagType): Boolean {
        for (i in tags) {
            if (i.equals(tagType)) {
                tags.remove(i)
            }
        }
        return false
    }
}