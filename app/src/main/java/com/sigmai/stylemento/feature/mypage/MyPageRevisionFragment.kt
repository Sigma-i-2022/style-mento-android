package com.sigmai.stylemento.feature.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.sigmai.stylemento.R
import com.sigmai.stylemento.databinding.FragmentMyPageBinding
import com.sigmai.stylemento.databinding.FragmentMyPageClosetBinding
import com.sigmai.stylemento.databinding.FragmentMyPageRevisionBinding
import com.sigmai.stylemento.global.base.BaseFragment

class MyPageRevisionFragment : BaseFragment<FragmentMyPageRevisionBinding>() {
    override val layoutResourceId = R.layout.fragment_my_page_revision

    val testDataSet = arrayOf("type1", "type2", "type3")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tagAdapter = MyPageTagAdapter(testDataSet)
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        binding.myPageRevisionStyleTagRecyclerView.adapter = tagAdapter
        binding.myPageRevisionStyleTagRecyclerView.layoutManager = linearLayoutManager

        binding.myPageRevisionBackImg.setOnClickListener(View.OnClickListener {
            if(true){
                val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
                transaction.commit()
            }
            else{
                val transaction = parentFragmentManager.beginTransaction().replace(R.id.my_page_frameLayout, MyPageUserFragment())
                transaction.commit()
            }
        })
    }
}