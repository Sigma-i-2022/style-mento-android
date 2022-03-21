package com.sigmai.stylemento.data.repository.alarm

import com.sigmai.stylemento.domain.repository.AlarmRepository
import javax.inject.Inject

class AlarmRepositoryImpl @Inject constructor(private val dataSource: AlarmDataSource) :
    AlarmRepository {
    override fun postAlarm(email: String, alarmMsg: String): Boolean {
        return dataSource.postAlarm(email, alarmMsg)
    }
}