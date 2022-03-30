package com.sigmai.stylemento.domain.repository

interface BlockRepository {
    fun postBlock(email : String, crdiEmail : String) : Boolean
}