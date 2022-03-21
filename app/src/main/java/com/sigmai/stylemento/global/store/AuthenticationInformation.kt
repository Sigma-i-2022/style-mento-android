package com.sigmai.stylemento.global.store

import androidx.lifecycle.MutableLiveData

object AuthenticationInformation {
    val email = MutableLiveData("")
    val sessionId = MutableLiveData("") // TODO : 서버에 로그인 인증 정보가 추가되면 email 대신 요거를 사용하세요.
}