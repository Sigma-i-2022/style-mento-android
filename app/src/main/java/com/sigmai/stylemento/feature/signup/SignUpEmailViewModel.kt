package com.sigmai.stylemento.feature.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sigmai.stylemento.R

class SignUpEmailViewModel : ViewModel() {
    companion object {
        const val NUMBER_OF_PAGE = 2
    }
    val currentPageIndex = MutableLiveData(0)
    val pageTitle = listOf("이메일 주소를 입력해주세요", "메일로 인증코드를 보내드렸어요\n확인 후 입력해주세요")
    val hints = listOf("stylemento@naver.com", "")
    val inputText = listOf(MutableLiveData<String?>(), MutableLiveData<String?>())
    val buttonText = listOf("인증번호 받기", "인증하기")
    val isClickable = arrayListOf(MutableLiveData(false), MutableLiveData(false))

    fun nextPage(navController: NavController? = null) {
        if(!isClickable[currentPageIndex.value!!].value!!) return

        if(currentPageIndex.value!! == 0) {
            val nextPage = currentPageIndex.value!! + 1
            if(nextPage < NUMBER_OF_PAGE)
                currentPageIndex.postValue(nextPage)
        }
        else {
            navController?.navigate(R.id.action_signup_email_to_signup_password)
        }
    }

    fun previousPage() {
        val currentPage = currentPageIndex.value!!
        if(currentPage > 0)
            currentPageIndex.postValue(currentPage - 1)
    }
}