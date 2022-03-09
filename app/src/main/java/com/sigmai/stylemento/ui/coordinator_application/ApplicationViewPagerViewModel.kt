package com.sigmai.stylemento.ui.coordinator_application

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.global.util.SingleLiveEvent

class ApplicationViewPagerViewModel : ViewModel() {
    val snsList = MutableLiveData(mutableListOf(""))
    val introduction = MutableLiveData("")
    val textLength = MutableLiveData(0)

    val moveNextPageEvent = SingleLiveEvent<Any>()
    val movePreviousEvent = SingleLiveEvent<Any>()
    val finishEvent = SingleLiveEvent<Any>()

    fun onPrevious(view: View) {
        movePreviousEvent.call()
    }

    fun onNext() {
        moveNextPageEvent.call()
    }

    fun onComplete(view: View) {
        val navController = view.findNavController()
        navController.navigate(R.id.action_application_viewpager_to_application_finish)
    }

    fun onAdd() {
        snsList.value!!.add("")
        snsList.value = snsList.value!!.toMutableList()
    }

    fun onFinish() {
        finishEvent.call()
    }
}