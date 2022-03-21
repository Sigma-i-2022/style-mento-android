package com.sigmai.stylemento.domain.repository

interface AlarmRepository {
    fun postAlarm(email: String, alarmMsg: String) : Boolean
}