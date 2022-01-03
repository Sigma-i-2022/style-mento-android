package com.sigmai.stylemento.feature.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpEmailViewModel : ViewModel() {
    companion object {
        const val NUMBER_OF_PAGE = 2
    }
    val currentPageIndex = MutableLiveData(0)
    val pageTitle = arrayListOf("이메일 주소를 입력해주세요", "메일로 인증코드를 보내드렸어요\n확인 후 입력해주세요")
    var inputText = arrayListOf(MutableLiveData<String?>(), MutableLiveData<String?>())

    fun nextPage() {
        val nextPage = currentPageIndex.value!! + 1
        if(nextPage < NUMBER_OF_PAGE)
            currentPageIndex.postValue(nextPage)
    }

    fun previousPage() {
        val currentPage = currentPageIndex.value!!
        if(currentPage > 0)
            currentPageIndex.postValue(currentPage - 1)
    }
}