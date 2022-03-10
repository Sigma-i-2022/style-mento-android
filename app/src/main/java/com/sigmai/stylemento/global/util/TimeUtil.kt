package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.data.model.TimeItem

object TimeUtil {
    val timeList = listOf(
        TimeItem("08:00"),
        TimeItem("08:30"),
        TimeItem("09:00"),
        TimeItem("09:30"),
        TimeItem("10:00"),
        TimeItem("10:30"),
        TimeItem("11:00"),
        TimeItem("11:30"),
        TimeItem("12:00"),
        TimeItem("12:30"),
        TimeItem("13:00"),
        TimeItem("13:30"),
        TimeItem("14:00"),
        TimeItem("14:30"),
        TimeItem("15:00"),
        TimeItem("15:30"),
        TimeItem("16:00"),
        TimeItem("16:30"),
        TimeItem("17:00"),
        TimeItem("17:30"),
        TimeItem("18:00"),
        TimeItem("18:30"),
        TimeItem("19:00"),
        TimeItem("19:30"),
        TimeItem("20:00"),
        TimeItem("20:30"),
        TimeItem("21:00"),
        TimeItem("21:30"),
        TimeItem("22:00"),
        TimeItem("22:30")
    )

    fun getSelectedTimeList(timeList : List<TimeItem>) : List<String>{
        val list = mutableListOf<String>()
        for(item in timeList){
            if(item.isChecked)
                list.add(item.time)
        }
        return list
    }
}