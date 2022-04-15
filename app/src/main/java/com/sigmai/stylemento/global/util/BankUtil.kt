package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.data.model.TimeItem

object BankUtil {
    private val bankList = listOf<String>(
        "NH농협",
        "우리",
        "신한",
        "KB국민",
        "하나",
        "시티",
        "IBK기업",
        "케이뱅크",
        "산업",
        "카카오뱅크",
        "수협",
        "전북",
        "제주",
        "부산",
        "대구",
        "외환",
        "기업",
        "새마을",
        "SC은행"
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