package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.UserType


object Client {
    private var clientType : UserType = UserType.NORMAL
    fun getClientType() : UserType{
        return clientType
    }
    fun setClientType(type : UserType){
        clientType = type
    }
    private var userInfo = User("test", "test@email")
    fun getUserInfo() : User{
        return userInfo
    }
    fun setUserInfo(userInfo : User){
        this.userInfo = userInfo
    }


    fun addClosetItem(item : ClosetItem){
        userInfo.closetItems.add(item)
    }
    fun removeClosetItem(position : Int){
        userInfo.closetItems.removeAt(position)
    }
    fun reviseClosetItem(item : ClosetItem, position : Int){
        userInfo.closetItems.removeAt(position)
        userInfo.closetItems.add(position, item)
    }
    fun addLookbookItem(item : LookbookItem){
        userInfo.lookbookItems.add(item)
    }
    fun removeLookbookItem(position : Int){
        userInfo.lookbookItems.removeAt(position)
    }
    fun reviseLookbookItem(item : LookbookItem, position : Int){
        userInfo.lookbookItems.removeAt(position)
        userInfo.lookbookItems.add(position, item)
    }

}