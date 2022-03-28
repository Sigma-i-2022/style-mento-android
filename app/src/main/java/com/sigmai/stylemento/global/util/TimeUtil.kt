package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.data.model.TimeItem

object TimeUtil {
    var timeList = (8..22).flatMap {
        val hour = if(it < 10) "0$it" else it.toString()
        listOf(
            TimeItem("$hour:00"),
            TimeItem("$hour:30")
        )
    }

    fun getSelectedTimeList(timeList : List<TimeItem>) : List<String>{
        val list = mutableListOf<String>()
        for(item in timeList){
            if(item.isChecked)
                list.add(item.time)
        }
        return list
    }
    fun resetTimeList() : List<TimeItem>{
        timeList = (8..22).flatMap {
            val hour = if(it < 10) "0$it" else it.toString()
            listOf(
                TimeItem("$hour:00"),
                TimeItem("$hour:30")
            )
        }
        return timeList
    }
    fun isSelected() : Boolean{
        for(item in timeList){
            if(item.isChecked)
                return true
        }
        return false
    }
}