package com.myapplicationdev.android.lp3quiz1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;

public class SceduledNotifcationReciever extends BroadcastReceiver {
    int reqCode = 12345;


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Bundle args = intent.getBundleExtra("DATA");


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Marketing Channel","Marketing Channel",NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("this is Marketing notification notification");
            notificationManager.createNotificationChannel(channel);
        }
        Intent i = new Intent(context,MainActivity.class);
        PendingIntent pIntent =  PendingIntent.getActivity(context,reqCode,i,PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"Marketing Channel");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);

        Notification n = builder.build();
        notificationManager.notify(123,n);





    }
}