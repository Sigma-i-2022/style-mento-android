package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.data.model.TimeItem

object BankUtil {
    private val bankList = listOf<String>(
        "경남",
        "광주",
        "시티",
        "산림",
        "NH농협",
        "우리",
        "신한",
        "KB국민",
        "하나",
        "저축",
        "산업",
        "케이",
        "토스",
        "카카오",
        "수협",
        "신협",
        "전북",
        "제주",
        "부산",
        "대구",
        "우체국",
        "기업",
        "새마을",
        "SC제일"
    )

    fun getBankList() : List<String>{
        return bankList
    }
    fun getBank(position : Int) : String{
        return bankList[position]
    }
    fun getPosition(bank : String) : Int{
        for(i in 0..bankList.size){
            if (bank == bankList[i])
                return i
        }
        return -1
    }
}