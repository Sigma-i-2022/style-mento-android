package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.View
import android.widget.ImageView
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

        val closetRecyclerView : RecyclerView = view.findViewById(R.id.my_page_user_closet_recycler)
        val closetAdapter = UserClosetAdapter(testDataSet)
        val gridLayoutManager = GridLayoutManager(context,3, GridLayoutManager.VERTICAL, false)

        closetRecyclerView.adapter = closetAdapter
        closetRecyclerView.layoutManager = gridLayoutManager

        val addButton : ImageView = view.findViewById(R.id.my_page_user_closet_add_img)
        addButton.setOnClickListener(View.OnClickListener {
            val dialog = UserClosetAddDialog()
            dialog.show(childFragmentManager, "closetDialog")
        })
    }
}