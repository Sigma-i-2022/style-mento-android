package com.sigmai.stylemento.feature.mypage.user.dialog

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogTagSelectionBinding
import com.sigmai.stylemento.feature.mypage.user.MyPageLookbookAddFragment
import com.sigmai.stylemento.feature.mypage.user.MyPageLookbookRevisionFragment
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.util.TransformToEnumUtil
import com.sigmai.stylemento.global.util.TransformToIntUtil

class UserLookbookTagSelectionDialog(private val f: Fragment) : BaseDialogFragment<DialogTagSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_tag_selection
    private var tags: MutableList<TagType> = mutableListOf()
    private var tagSize: Int = 0
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

        binding.tagSelectionSaveButton.setOnClickListener(View.OnClickListener {
            addTags()
            when (f) {
                is MyPageLookbookAddFragment -> f.setTags(tags)
                is MyPageLookbookRevisionFragment -> f.setTags(tags)
            }
            dismiss()
        })

        binding.tagSelectionCasulalText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionCasulalText, TagType.CASULAL)
        })
        binding.tagSelectionStreetText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionStreetText, TagType.STREET)
        })
        binding.tagSelectionModernText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionModernText, TagType.MODERN)
        })
        binding.tagSelectionFeminineText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionFeminineText, TagType.FEMININE)
        })
        binding.tagSelectionDandyText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionDandyText, TagType.DANDY)
        })
        binding.tagSelectionMinimalText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionMinimalText, TagType.MINIMAL)
        })
        binding.tagSelectionMaximalText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionMaximalText, TagType.MAXIMAL)
        })
        binding.tagSelectionCityText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionCityText, TagType.CITY)
        })
        binding.tagSelectionAmericanCasualText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionAmericanCasualText, TagType.AMERICANCASUAL)
        })
        binding.tagSelectionClassicText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionClassicText, TagType.CLASSIC)
        })
        binding.tagSelectionStudentText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionStudentText, TagType.STUDENT)
        })
        binding.tagSelectionOfficeText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionOfficeText, TagType.OFFICE)
        })
        binding.tagSelectionDateText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionDateText, TagType.DATE)
        })
        binding.tagSelectionBlindDateText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionBlindDateText, TagType.BLINDDATE)
        })
        binding.tagSelectionTourText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionTourText, TagType.TRAVEL)
        })
        binding.tagSelectionPartyText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionPartyText, TagType.PARTY)
        })
        binding.tagSelectionCoupleText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionCoupleText, TagType.COUPLE)
        })
        binding.tagSelectionGuestText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionGuestText, TagType.GUEST)
        })
        binding.tagSelectionSpringText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionSpringText, TagType.SPRING)
        })
        binding.tagSelectionSummerText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionSummerText, TagType.SUMMER)
        })
        binding.tagSelectionAutumnText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionAutumnText, TagType.AUTUMN)
        })
        binding.tagSelectionWinterText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionWinterText, TagType.WINTER)
        })
        binding.tagSelectionRainText.setOnClickListener(View.OnClickListener {
            onTextViewClick(binding.tagSelectionRainText, TagType.RAIN)
        })
    }

    private fun onTextViewClick(textView: TextView, tagType: TagType) {
        val index = intUtil.getTagInt(tagType)
        var state = !tagStates[index]

        if (state && onTagNumber < 4) {
            onTagNumber++
            textView.setBackgroundResource(R.drawable.button_round_click)
            tagStates[index] = state
        } else if(!state && onTagNumber >= 0) {
            onTagNumber--
            textView.setBackgroundResource(R.drawable.button_round)
            tagStates[index] = state
        }
    }

    private fun addTags() {
        val enumUtil = TransformToEnumUtil()
        for (i: Int in 0 until 24) {
            if (tagStates[i]) {
                tags.add(enumUtil.getTagType(i))
            }
        }
    }
}
