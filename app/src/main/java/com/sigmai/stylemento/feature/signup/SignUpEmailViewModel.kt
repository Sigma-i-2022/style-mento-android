package com.sigmai.stylemento.feature.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpEmailViewModel : ViewModel() {
    companion object {
        const val NUMBER_OF_PAGE = 3
    }
    val currentPageIndex = MutableLiveData(0)
    val pageTitle = arrayListOf("이메일 주소를 입력해주세요", "비밀번호를 입력해주세요", "비밀번호를 \n다시 한 번 입력해주세요")
    var inputText = arrayListOf(MutableLiveData<String?>(), MutableLiveData<String?>(), MutableLiveData<String?>())

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