package com.sigmai.stylemento.data.repository.alarm

import com.sigmai.stylemento.data.api.AlarmService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import javax.inject.Inject

class AlarmDataSource @Inject constructor() {
    private val service = RetrofitServiceFactory.createService<AlarmService>()

    fun postAlarm(email: String, alarmMsg: String) : Boolean{
        return service.postAlarm(email, alarmMsg).execute().body()?.success ?: false
    }
}