package com.sigmai.stylemento.data.repository.datasource

import com.sigmai.stylemento.data.model.Client

class DummyDataSource {
    private val client = Client

    fun getUserInfo() = client.getUserInfo()
}