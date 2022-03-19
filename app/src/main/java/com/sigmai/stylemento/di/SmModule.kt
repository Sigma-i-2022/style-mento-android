package com.sigmai.stylemento.di

import com.sigmai.stylemento.data.api.SignupService
import com.sigmai.stylemento.data.factory.RetrofitServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object SmModule {
    @Provides
    fun SignupService() : SignupService {
        return RetrofitServiceFactory.createService()
    }
}