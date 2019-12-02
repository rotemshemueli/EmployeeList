package com.rosol.employeelist.sync;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.rosol.employeelist.BirthdayCard;
import com.rosol.employeelist.R;


public class NotificationUtils {
    public static final int BIRTHDAY_REMINDER_ID=101;
    private static final String BIRTHDAY_REMINDER_CHANNEL_ID="reminder-notification-channel";

    public static void birthdayReminder(Context context){
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel reminderNotification= new NotificationChannel(BIRTHDAY_REMINDER_CHANNEL_ID,"Birthday Notification",NotificationManager.IMPORTANCE_DEFAULT);
            nm.createNotificationChannel(reminderNotification);
        }

        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(context,BIRTHDAY_REMINDER_CHANNEL_ID)
                .setAutoCancel(true)
                .setContentIntent(contentIntent(context))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.drawable.ic_cake)
                .setLargeIcon(largeIcon(context))
                .setContentTitle(context.getString(R.string.title))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.title)))
                .setColor(ContextCompat.getColor(context,R.color.notification));

        nm.notify(BIRTHDAY_REMINDER_ID,notificationBuilder.build());

    }

    private static PendingIntent contentIntent(Context context){
        Intent openBirthdayCardActivity= new Intent(context, BirthdayCard.class);
        return PendingIntent.getActivity(context,BIRTHDAY_REMINDER_ID,openBirthdayCardActivity,PendingIntent.FLAG_UPDATE_CURRENT);

    }


    private static Bitmap largeIcon (Context context){
        Resources res= context.getResources();
        Bitmap largeIcon= BitmapFactory.decodeResource(res, R.drawable.ic_cake);
        return largeIcon;
    }


}
