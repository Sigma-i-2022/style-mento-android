package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogTagSelectionBinding
import com.sigmai.stylemento.feature.mypage.adapter.SampleTagAdapter
import com.sigmai.stylemento.feature.mypage.user.HavingTag2
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.util.TransformToIntUtil
import com.sigmai.stylemento.global.util.TransformToStringUtil

class TagSelectionDialog(
    private val havingTag: HavingTag,
    private val havingTag2: HavingTag2? = null
) : BaseDialogFragment<DialogTagSelectionBinding>() {
    override val layoutResourceId = R.layout.dialog_tag_selection

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setGravity(Gravity.BOTTOM)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tagSelectionStyleTags.adapter = SampleTagAdapter(
            listOf(
                TransformToStringUtil().getTagString(TagType.CASULAL),
                TransformToStringUtil().getTagString(TagType.STREET),
                TransformToStringUtil().getTagString(TagType.MODERN),
                TransformToStringUtil().getTagString(TagType.FEMININE),
                TransformToStringUtil().getTagString(TagType.DANDY),
                TransformToStringUtil().getTagString(TagType.MINIMAL),
                TransformToStringUtil().getTagString(TagType.MAXIMAL),
                TransformToStringUtil().getTagString(TagType.CITY),
                TransformToStringUtil().getTagString(TagType.AMERICANCASUAL),
                TransformToStringUtil().getTagString(TagType.CLASSIC)
            )
        )

        binding.tagSelectionSituationTags.adapter = SampleTagAdapter(
            listOf(
                TransformToStringUtil().getTagString(TagType.STUDENT),
                TransformToStringUtil().getTagString(TagType.OFFICE),
                TransformToStringUtil().getTagString(TagType.DATE),
                TransformToStringUtil().getTagString(TagType.BLINDDATE),
                TransformToStringUtil().getTagString(TagType.TRAVEL),
                TransformToStringUtil().getTagString(TagType.PARTY),
                TransformToStringUtil().getTagString(TagType.COUPLE),
                TransformToStringUtil().getTagString(TagType.GUEST),
            )
        )

        binding.tagSelectionWeatherTags.adapter = SampleTagAdapter(
            listOf(
                TransformToStringUtil().getTagString(TagType.SPRING),
                TransformToStringUtil().getTagString(TagType.SUMMER),
                TransformToStringUtil().getTagString(TagType.AUTUMN),
                TransformToStringUtil().getTagString(TagType.WINTER),
                TransformToStringUtil().getTagString(TagType.RAIN),
            )
        )

        binding.tagSelectionSaveButton.setOnClickListener{
            val selectedTagList1 = (binding.tagSelectionStyleTags.adapter as SampleTagAdapter).selectedTags
            val selectedTagList2 = (binding.tagSelectionSituationTags.adapter as SampleTagAdapter).selectedTags
            val selectedTagList3 = (binding.tagSelectionWeatherTags.adapter as SampleTagAdapter).selectedTags
            val selectedTagList = selectedTagList1 + selectedTagList2 + selectedTagList3
            havingTag2?.setTagList(selectedTagList)
            dismiss()
        }
    }
}
