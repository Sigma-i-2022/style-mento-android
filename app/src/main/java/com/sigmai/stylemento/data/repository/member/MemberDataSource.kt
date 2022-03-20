package com.sigmai.stylemento.data.repository.member

import com.sigmai.stylemento.data.api.MemberService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import javax.inject.Inject

class MemberDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<MemberService>()

}