package com.example.brew

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotisReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val channelId = "brew_daily_channel"

        val manager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return

        // noti channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Brew's Daily Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Sends daily reminders"
            }

            manager.createNotificationChannel(channel)


            // builds n shows noti
            val notification = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.icon_beans)
                .setContentTitle("Brew Reminder")
                .setContentText("Ready for your daily brew?")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .build()

            manager.notify(1, notification)
        }
    }
}