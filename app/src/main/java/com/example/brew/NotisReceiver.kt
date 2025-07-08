package com.example.brew

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class NotisReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val channelId = "brew_daily_channel"

        // noti channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Brew's Daily Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Sends daily reminders"
            }
            if (context != null) {
                val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }
        }
    }
}