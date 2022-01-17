package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageClosetBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageClosetFragment : BaseFragment<FragmentMyPageClosetBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_closet

    val testDataSet = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closetAdapter = UserClosetAdapter(testDataSet)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        binding.myPageUserClosetRecycler.adapter = closetAdapter
        binding.myPageUserClosetRecycler.layoutManager = gridLayoutManager

        /*binding.myPageUserClosetAddImg.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetAddDialog()
            dialog.show(childFragmentManager, "closetDialog")
        })*/
        binding.myPageUserClosetAddImg.setOnClickListener(View.OnClickListener {
            val transaction = parentFragment?.parentFragmentManager?.beginTransaction()
            if (transaction != null) {
                transaction.replace(R.id.my_page_frameLayout, MyPageClosetAddFragment())
            }
            if (transaction != null) {
                transaction.commit()
            }
        })

        binding.myPageUserClosetAllText.setOnClickListener(View.OnClickListener {
            setAllTextGray()
            context?.let { binding.myPageUserClosetAllText.setTextColor(it.getColor(R.color.black)) }
        })
        binding.myPageUserClosetTopText.setOnClickListener(View.OnClickListener {
            setAllTextGray()
            context?.let { binding.myPageUserClosetTopText.setTextColor(it.getColor(R.color.black)) }
        })
        binding.myPageUserClosetPantsText.setOnClickListener(View.OnClickListener {
            setAllTextGray()
            context?.let { binding.myPageUserClosetPantsText.setTextColor(it.getColor(R.color.black)) }
        })
        binding.myPageUserClosetShoesText.setOnClickListener(View.OnClickListener {
            setAllTextGray()
            context?.let { binding.myPageUserClosetShoesText.setTextColor(it.getColor(R.color.black)) }
        })
    }

    private fun setAllTextGray(){ //viewModel로 더 효율적이게 가능할지도?
        context?.let { binding.myPageUserClosetAllText.setTextColor(it.getColor(R.color.gray_d)) }
        context?.let { binding.myPageUserClosetTopText.setTextColor(it.getColor(R.color.gray_d)) }
        context?.let { binding.myPageUserClosetPantsText.setTextColor(it.getColor(R.color.gray_d)) }
        context?.let { binding.myPageUserClosetShoesText.setTextColor(it.getColor(R.color.gray_d)) }
    }
}