package com.demo.zk.manxiang.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HG on 2015/12/3.
 */
public class WarmService extends Service {

    static Timer timer = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(timer==null){
            timer = new Timer();
        }
        final long seckill_id = intent.getLongExtra("seckill_id",0);
        long len =  intent.getLongExtra("len", 0);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
               /* Intent intent = new Intent(getContext(), MiaoshaDetailsActivity.class);
                intent.putExtra("seckill_id", seckill_id);
                PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 0, intent, 0);
                Notification.Builder builder = new Notification.Builder(getContext());
                builder.setContentIntent(pendingIntent)
                        .setContentTitle("秒杀提醒")
                        .setContentText("漫像秒杀活动已开始了，快来抢购吧。")
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.icon_launcher)
                        .setDefaults(Notification.DEFAULT_ALL);
                Notification notification = builder.build();

                notificationManager.notify(1001, notification);*/
            }
        }, len);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {
        if(timer !=null){
            timer.cancel();
        }
        return super.stopService(name);
    }

    public Context getContext(){
        return this;
    }
}
