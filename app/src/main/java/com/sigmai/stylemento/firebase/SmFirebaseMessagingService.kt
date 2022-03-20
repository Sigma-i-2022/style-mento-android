package com.sigmai.stylemento.firebase
import android.content.Context
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

class SmFirebaseMessagingService : FirebaseMessagingService() {
    override fun onCreate() {
        super.onCreate()
        Timber.d("파이어베이스 서비스 생성")
    }

    override fun onNewToken(token: String) {
        val pref = this.getSharedPreferences("token", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("token", token).apply()
        editor.commit()

        println("성공")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val title = message.notification!!.title
        val body = message.notification!!.body
        Timber.d("타이틀 ${title!!}")
        Timber.d("바디 ${body!!}")
    }

    fun getToken(context: Context) : String {
        return context.getSharedPreferences("token", MODE_PRIVATE).getString("token", "empty") ?: ""
    }
}