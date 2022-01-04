package com.sigmai.stylemento.feature.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpEmailViewModel : ViewModel() {
    companion object {
        const val NUMBER_OF_PAGE = 2
    }
    val currentPageIndex = MutableLiveData(0)
    val pageTitle = listOf("이메일 주소를 입력해주세요", "메일로 인증코드를 보내드렸어요\n확인 후 입력해주세요")
    val hints = listOf("stylemento@naver.com", "")
    val inputText = listOf(MutableLiveData<String?>(), MutableLiveData<String?>())
    val buttonText = listOf("인증번호 받기", "인증하기")

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