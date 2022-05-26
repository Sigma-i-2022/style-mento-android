package com.sigmai.stylemento.ui.coordinator_application

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sigmai.stylemento.R
import com.sigmai.stylemento.data.repository.myPage.MyPageRepositoryImpl
import com.sigmai.stylemento.data.repository.signup.SignupRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ApplicationViewPagerViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var singupRepository : SignupRepositoryImpl
    @Inject
    lateinit var myPageRepository: MyPageRepositoryImpl

    val snsList = MutableLiveData(mutableListOf(MutableLiveData("")))
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
        requestUpgrade()
        val navController = view.findNavController()
        navController.navigate(R.id.action_application_viewpager_to_application_finish)
    }

    fun onAdd() {
        snsList.value!!.add(MutableLiveData(""))
        snsList.value = snsList.value!!.toMutableList()
    }

    fun onFinish() {
        finishEvent.call()
    }

    private val snsArray = Array<String>(5){""}
    fun requestUpgrade(){
        val i = 0
        for(sns in snsList.value!!){
            snsArray[i] = sns.value!!
        }
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                singupRepository.join(AuthenticationInfo.email.value!!, introduction.value!!
                    , snsArray[0], snsArray[1], snsArray[2], snsArray[3], snsArray[4])
            }
        }
    }
}