package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.DialogTagSelectionBinding
import com.sigmai.stylemento.feature.mypage.adapter.SampleTagAdapter
import com.sigmai.stylemento.global.base.BaseDialogFragment
import com.sigmai.stylemento.global.base.HavingTag
import com.sigmai.stylemento.global.base.HavingTag2
import com.sigmai.stylemento.global.constant.TagType
import com.sigmai.stylemento.global.util.TransformToIntUtil
import com.sigmai.stylemento.global.util.TransformToStringUtil

class TagSelectionDialog(
    private val havingTag: HavingTag? = null,
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

        val styleTagList = TagType.getStyleTagList().map { tagType ->
            TransformToStringUtil().getTagString(tagType)
        }
        val situationTagList = TagType.getSituationTagList().map { tagType ->
            TransformToStringUtil().getTagString(tagType)
        }
        val weatherTagList = TagType.getWeatherTagList().map { tagType ->
            TransformToStringUtil().getTagString(tagType)
        }

        binding.tagSelectionStyleTags.adapter = SampleTagAdapter(styleTagList)
        binding.tagSelectionSituationTags.adapter = SampleTagAdapter(situationTagList)
        binding.tagSelectionWeatherTags.adapter = SampleTagAdapter(weatherTagList)

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
