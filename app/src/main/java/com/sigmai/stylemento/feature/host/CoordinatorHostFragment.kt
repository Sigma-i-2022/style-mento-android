package com.sigmai.stylemento.feature.host

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sigmai.stylemento.R

@Deprecated("여러 개의 NavHost -> 한 개로 리팩터링하면서 필요 없어짐")
class CoordinatorHostFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coordinator_host, container, false)
    }
}