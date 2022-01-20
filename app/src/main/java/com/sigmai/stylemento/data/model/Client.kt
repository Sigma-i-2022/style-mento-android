package com.sigmai.stylemento.data.model

import com.sigmai.stylemento.global.constant.UserType


object Client {
    var userInfo = User(UserType.NORMAL, "test", "test@email")

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