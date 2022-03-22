package com.sigmai.stylemento.data.model.response

data class Member(
    val activateYn: String,
    val crdiYn : String,
    val email : String,
    val password : String,
    val registDate : String,
    val reportedYn : String,
    val signupType : String,
    val userID : String,
    val userSeq : Long
)