package com.example.theplug.BroadcastReceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

import com.example.theplug.Activities.MainActivity;
import com.example.theplug.R;

public class NotificationReceiver extends BroadcastReceiver {
    private static final int NOTIFICATION_ID = 0;
    private static final String thePlugUrl = "https://theplug.mk/";


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent learnMoreIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thePlugUrl));
        PendingIntent learnMorePendingIntent = PendingIntent.getActivity(context,NOTIFICATION_ID,learnMoreIntent,PendingIntent.FLAG_ONE_SHOT);
        Intent contentIntent = new Intent(context, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.logo);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Check out our new items on sale")
                .setContentText("Many rare clothing items, Check it out")
                .setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(bitmap))
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .addAction(R.drawable.more,"Check out our web pagee",learnMorePendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        notificationManager.notify(NOTIFICATION_ID, builder.build());

    }
}
