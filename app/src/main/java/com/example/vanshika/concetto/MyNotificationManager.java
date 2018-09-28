package com.example.vanshika.concetto;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.vanshika.concetto.Models.constants;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by lenovo on 9/29/2018.
 */

class MyNotificationManager {
    public static MyNotificationManager getInstance;
    private Context mCtx;
    private static MyNotificationManager mInstance;

    private MyNotificationManager(Context context) {
        mCtx = context;
    }

    public static synchronized MyNotificationManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyNotificationManager(context);
        }
        return mInstance;
    }

    public void displayNotification(String title, String body) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(mCtx, constants.CHANNEL_ID)
                        .setSmallIcon(R.drawable.concetto_white)
                        .setContentTitle(title)
                        .setContentText(body);


        /*
        *  Clicking on the notification will take us to this intent*/

        Intent resultIntent = new Intent(mCtx, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(mCtx, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);



        mBuilder.setContentIntent(pendingIntent);

        NotificationManager mNotifyMgr =
                (NotificationManager) mCtx.getSystemService(NOTIFICATION_SERVICE);


        if (mNotifyMgr != null) {
            mNotifyMgr.notify(1, mBuilder.build());
        }
    }
}
