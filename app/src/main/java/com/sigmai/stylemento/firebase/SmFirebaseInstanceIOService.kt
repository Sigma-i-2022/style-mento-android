package com.sigmai.stylemento.firebase
import android.content.Context
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class SmFirebaseInstanceIOService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        val pref = this.getSharedPreferences("token", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("token", token).apply()
        editor.commit()

        println("성공")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("메시지", message.from.toString())

        if(message.data.isNotEmpty()) {
            Log.i("바디: ", message.data["body"].toString())
            Log.i("타이틀: ", message.data["title"].toString())
        }

        else {
            Log.i("수신에러: ", "data가 비어있습니다. 메시지를 수신하지 못했습니다.")
            Log.i("data값: ", message.data.toString())
        }
    }

    fun getToken(context: Context) : String {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("token", "empty") ?: ""
    }
}