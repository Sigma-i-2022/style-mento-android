package com.sigmai.stylemento.data.factory

import com.sigmai.stylemento.global.store.AuthenticationInfo
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class AuthenticationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Authorization", AuthenticationInfo.accessToken.value)
        builder.addHeader("Authorization-refresh", AuthenticationInfo.refreshToken.value)

        Timber.e("acc ㅁㅁㅁㅁ ${AuthenticationInfo.accessToken.value}")
        Timber.e("refresh ㅁㅁㅁㅁ ${AuthenticationInfo.refreshToken.value}")

        val request = builder.build()

        val originalResponse = chain.proceed(request)

        val accessToken = originalResponse.headers["Authorization"]
        val refreshToken = originalResponse.headers["Authorization-refresh"]

        accessToken?.let {
            AuthenticationInfo.accessToken.value = accessToken
        }

        refreshToken?.let {
            AuthenticationInfo.refreshToken.value = refreshToken
        }

        return originalResponse
    }
}