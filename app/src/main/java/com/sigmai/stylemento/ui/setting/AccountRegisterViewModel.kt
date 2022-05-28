package com.sigmai.stylemento.ui.setting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sigmai.stylemento.data.repository.openApi.OpenApiRepositoryImpl
import com.sigmai.stylemento.data.repository.submall.SubMallRepositoryImpl
import com.sigmai.stylemento.global.store.AuthenticationInfo
import com.sigmai.stylemento.global.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AccountRegisterViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var openApiRepository: OpenApiRepositoryImpl

    @Inject
    lateinit var submallRepository: SubMallRepositoryImpl

    val accountNumber = MutableLiveData<String>("")
    val owner = MutableLiveData<String>("")
    val bank = MutableLiveData<String>("")
    val birthday = MutableLiveData<String>("")

    val startBack = SingleLiveEvent<Any>()
    val startNext = SingleLiveEvent<Any>()
    val startSetBank = SingleLiveEvent<Any>()

    fun onBackClick() {
        startBack.call()
    }

    fun onNextClick() {
        startNext.call()
    }

    fun onSetBankClick() {
        startSetBank.call()
    }

    fun saveInfo() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val bankName = if (bank.value!! == "카카오") "카카오뱅크" else "${bank.value!!}은행"

                submallRepository.postSubMall(
                    bankName,
                    accountNumber.value!!,
                    owner.value!!,
                    AuthenticationInfo.email.value!!,
                    "상호명",
                    "대표자",
                    "개인",
                    null
                )
            }
        }
    }
}