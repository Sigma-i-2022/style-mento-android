package com.sigmai.stylemento.feature.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.sigmai.stylemento.R

class SignUpPasswordViewModel : ViewModel() {
    companion object {
        const val NUMBER_OF_PAGE = 2
    }
    val currentPageIndex = MutableLiveData(0)
    val pageTitle = listOf("비밀번호를 입력해주세요", "비밀번호를\n다시 한 번 입력해주세요")
    val inputText = listOf(MutableLiveData<String?>(), MutableLiveData<String?>())
    val information = listOf("영문과 숫자를 포함한 8자 이상의 비밀번호로 구성해주세요.", "비밀번호가 일치하지 않습니다.")
    val isValidPassword = listOf(MutableLiveData(false), MutableLiveData(false))

    fun nextPage(navController: NavController?) {
        if(!isValidPassword[currentPageIndex.value!!].value!!) return

        if(currentPageIndex.value!! == 0) {
            val nextPage = currentPageIndex.value!! + 1
            if(nextPage < SignUpEmailViewModel.NUMBER_OF_PAGE)
                currentPageIndex.postValue(nextPage)
        }
        else {
            navController?.navigate(R.id.action_signup_password_to_signup_finish)
        }
    }

    fun previousPage() {
        val currentPage = currentPageIndex.value!!
        if(currentPage > 0)
            currentPageIndex.postValue(currentPage - 1)
    }
}