package com.sigmai.stylemento.firebase
import android.content.Context
import android.util.Log
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SmFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        val pref = this.getSharedPreferences("token", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("token", token).apply()
        editor.commit()

        Timber.d("새 토큰 값 저장 : $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val title = message.notification!!.title
        val body = message.notification!!.body
        Timber.d("타이틀 ${title!!}")
        Timber.d("바디 ${body!!}")
    }

    companion object {
        fun getToken(context: Context) : String {
            return context.getSharedPreferences("token", MODE_PRIVATE).getString("token", "empty") ?: ""
        }
    }
}