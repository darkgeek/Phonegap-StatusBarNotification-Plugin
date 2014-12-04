package edu.hdu.darkgeek.cordova.notification;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.app.Notification;
import android.app.Activity;
import android.support.v4.app.NotificationCompat;

import android.util.Log;

public class StatusBarNotification extends CordovaPlugin {
    public static final String TAG = "NotificationBarMessagePlugin";
    public static final String iconName = "icon";
    public NotificationManager notifManager = null;
    
    @Override
    public boolean execute(String action, JSONArray args, 
    CallbackContext callbackContext) throws JSONException {
        if ("sendNotify".equals(action)) {
            String title = args.getString(0);
            String text = args.getString(1);
            String ticker = args.getString(2);
            boolean enableExtraEffects = args.getBoolean(3);
            
            Log.d(TAG, "=================enableExtraEffects: " + enableExtraEffects);


            Activity activity = this.cordova.getActivity();
            Context context = activity.getApplicationContext();
            Intent intent = new Intent(context, activity.getClass());
            PendingIntent pi = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT); 
            int iconResID = context.getResources().getIdentifier(iconName,"drawable", context.getPackageName());
            notifManager = (NotificationManager) context.getSystemService(android.content.Context.NOTIFICATION_SERVICE);

            Notification noti = null;
            NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(context);

            notifBuilder.setSmallIcon(iconResID);
            notifBuilder.setTicker(ticker);
            notifBuilder.setWhen(System.currentTimeMillis());
            notifBuilder.setContentTitle(title);
            notifBuilder.setContentText(text);
            notifBuilder.setContentIntent(pi);
            if (enableExtraEffects)
                notifBuilder.setDefaults(Notification.DEFAULT_ALL);
            notifBuilder.setAutoCancel(true);

            noti = notifBuilder.build();

            notifManager.notify(1, noti);

            callbackContext.success();
            return true;
        }

        return false;
    }

    public void cancelAllNotifications() {
        if (notifManager == null)
            return;
        
        notifManager.cancelAll();
    }

    @Override
    public void onDestroy() {
        cancelAllNotifications();
        super.onDestroy();
    }
}
