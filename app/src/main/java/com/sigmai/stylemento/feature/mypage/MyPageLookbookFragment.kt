package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sigmai.stylemento.R

class MyPageLookbookFragment : Fragment() {
    val testDataSet = arrayOf("1", "2", "3")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_my_page_lookbook, container, false)

        val lookbookRecyclerView : RecyclerView = v.findViewById(R.id.user_lookbook_recycler)
        val lookbookAdapter = UserClosetAdapter(testDataSet)
        val gridLayoutManager = GridLayoutManager(context,3)

        gridLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        lookbookRecyclerView.adapter = lookbookAdapter
        lookbookRecyclerView.layoutManager = gridLayoutManager

        return v
    }
}