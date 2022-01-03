package com.sigmai.stylemento.feature.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpPasswordViewModel : ViewModel() {
    companion object {
        const val NUMBER_OF_PAGE = 2
    }
    val currentPageIndex = MutableLiveData(0)
    val pageTitle = listOf("비밀번호를 입력해주세요", "비밀번호를\n다시 한 번 입력해주세요")
    val inputText = listOf(MutableLiveData<String?>(), MutableLiveData<String?>())
    val information = listOf("영문과 숫자를 포하한 8자 이상의 비밀번호로 구성해주세요.")

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