package com.sigmai.stylemento.global.util

import com.sigmai.stylemento.data.model.TimeItem

object BankUtil {
    private val bankList = listOf<String>(
        "경남은행",
        "광주은행",
        "KB국민은행",
        "IBK기업은행",
        "NH농협은행",
        "단위농협",
        "DGB대구은행",
        "부산은행",
        "KDB산업은행",
        "새마을금고",
        "산림조합",
        "Sh수협은행",
        "신한은행",
        "신협",
        "씨티은행",
        "우리은행",
        "우체국예금보험",
        "저축은행중앙회",
        "전북은행",
        "제주은행",
        "카카오뱅크",
        "케이뱅크",
        "토스뱅크",
        "하나은행",
        "SC제일은행"
    )
    private val paybackBanklist = listOf<String>(
        "경남은행",
        "광주은행",
        "KB국민은행",
        "IBK기업은행",
        "NH농협은행",
        "DGB대구은행",
        "부산은행",
        "새마을금고",
        "Sh수협은행",
        "신한은행",
        "우리은행",
        "우체국예금보험",
        "전북은행",
        "케이뱅크",
        "하나은행",
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
    fun getPaybackBankList() : List<String>{
        return paybackBanklist
    }
    fun getPaybackBank(position : Int) : String{
        return paybackBanklist[position]
    }
    fun getPaybackPosition(bank : String) : Int{
        for(i in 0..paybackBanklist.size){
            if (bank == paybackBanklist[i])
                return i
        }
        return -1
    }
}