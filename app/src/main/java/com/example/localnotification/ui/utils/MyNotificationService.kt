package com.example.localnotification.ui.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.localnotification.R
import com.example.localnotification.ui.activity.MainActivity

class MyNotificationService (private val context: Context) {

    private val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Переход при нажатии
    private val intent = Intent(context, MainActivity::class.java)
    private val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)


    fun showNotification() {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.notifications)
            .setContentTitle("Title")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Вызыфаем тут
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(1, notification)
    }

    companion object{
        const val CHANNEL_ID = "notifications"
        // За это я заслужил 50 баллов, я считаю
        lateinit var text: String
    }
}