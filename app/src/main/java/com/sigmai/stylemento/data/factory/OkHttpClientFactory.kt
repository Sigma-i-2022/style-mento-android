package com.sigmai.stylemento.data.factory

import com.sigmai.stylemento.global.store.AuthenticationInfo
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class OkHttpClientFactory {
    companion object {
        fun create() : OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(createLoggingInterceptor())
                .addInterceptor(AuthenticationInterceptor())
                .build()
        }

        private fun createLoggingInterceptor() : HttpLoggingInterceptor {
            /**
             * file 통신할 때 base64 로 인코딩된 file 출력 방지
             */
            val interceptor = HttpLoggingInterceptor { message ->
                if (!message.contains("�")) {
                    Timber.d(message)
                }
            }

            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return interceptor
        }
    }
}