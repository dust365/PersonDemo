package com.example.dust.persondemo.activity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dust.persondemo.R;

import java.io.File;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class NotificationTestActivity extends android.support.v7.app.AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notification_test);

      TextView chatTV = findViewById(R.id.tv_chat);
      TextView pushTV = findViewById(R.id.tv_push);


        /**
         * 通知栏的适配
         */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            String channelId = "chat";
            String channelName = "聊天消息";

            //重要等级
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);



            channelId = "push";
            channelName = "推送消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importance);




        }



        /**
         * 聊天通知
         */
        chatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * 申请聊天的  通知权限
                 */

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = manager.getNotificationChannel("chat");
                    if (channel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
                        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channel.getId());
                        startActivity(intent);
                        Toast.makeText(NotificationTestActivity.this, "请手动打开通知和聊天消息开关", Toast.LENGTH_SHORT).show();
                    }
                }




                    //跳转的activity页面
                    Intent intent = new Intent(NotificationTestActivity.this, NotificationActivity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(NotificationTestActivity.this, 0, intent, 0);
//                    NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    Notification notification = new NotificationCompat.Builder(NotificationTestActivity.this,"chat")
                            .setContentTitle("我是个标题")
                            .setContentText("张三发来一条微信，我请你吃饭吧去？")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                            .setContentIntent(pendingIntent)//intent跳转
                            .setAutoCancel(true)//点击后是否取消
                            .setCategory("85858588888")
                            .setSound(Uri.fromFile(new File("/system/media/auto/ringtones/Luna.ogg")))
                            .setVibrate(new long[]{0,1000,1000,1000})
                            .setLights(Color.RED,1000,1000)
                            .setDefaults(NotificationCompat.DEFAULT_ALL)
                            .build();
                    manager.notify(1,notification);



            }
        });


        /**
         * 推送通知
         */
        pushTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /**
                 * 申请推送的  通知权限
                 */

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = manager.getNotificationChannel("push");
                    if (channel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
                        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channel.getId());
                        startActivity(intent);
                        Toast.makeText(NotificationTestActivity.this, "请手动打开通知和推送通知开关", Toast.LENGTH_SHORT).show();
                    }
                }



                //跳转的activity页面
                Intent intent = new Intent(NotificationTestActivity.this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationTestActivity.this, 0, intent, 0);
//                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification notification = new NotificationCompat.Builder(NotificationTestActivity.this,"push")
                        .setContentTitle("我是个标题")
                        .setContentText("支付宝到账100万，查收点这里！")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)//intent跳转
                        .setAutoCancel(true)//点击后是否取消
                        .setCategory("85858588888")
                        .setSound(Uri.fromFile(new File("/system/media/auto/ringtones/Luna.ogg")))
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .setLights(Color.RED,1000,1000)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .build();
                assert manager != null;
                manager.notify(2,notification);








            }
        });





    }





    /**
     *    android    O以上的通知 适配
     * @param channelId
     * @param channelName
     * @param importance
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {

        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);




    }


}
