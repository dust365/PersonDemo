# PersonDemo

[![API](https://img.shields.io/badge/API-20%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=20)

## 我个人一些测试demo的合集



* 1.NDK的一些测试样例。
* 2.一些设计模式的自我练习。
* 3.grovy学习的一些 基础写法。
* 4.Xml的解析。
* 5.svg 构造地图，异型区域选中效果变色效果。

 ![image](https://github.com/dust365/PersonDemo/blob/master/app/src/main/res/raw/map.gif)

* 6.直播的送礼物动画, 可以定义更多颜色的图片,效果更炫

 ![image](https://github.com/dust365/PersonDemo/blob/master/app/src/main/res/raw/start.gif)

* 7.listView recycleView 侧滑删除效果

 ![image](https://github.com/dust365/PersonDemo/blob/master/app/src/main/res/raw/slidingdelete.gif)
* 8.画笔基础paint和自定义控件百分比饼状图效果

 ![GitHub](https://github.com/dust365/PersonDemo/blob/master/app/src/main/res/raw/shanxing.png "GitHub,Social Coding")
 
 * 9 夜间模式 
 
  ![image](https://github.com/dust365/PersonDemo/blob/master/app/src/main/res/raw/nightgif.gif)

 
 * 10.RxJava RxPermissions动态申请权限解决权限回调分割代码业务的问题
    
```
     RxPermissions rxPermissions = new RxPermissions(MainActivity.this); // where this is an Activity instance
                //不区分拒绝  状态权限的申请
                rxPermissions
                        .request(Manifest.permission.CAMERA,Manifest.permission.INTERNET)
                        .subscribe(new Consumer<Boolean>() {
                         @Override
                          public void accept(Boolean granted) throws Exception {

                                if (granted) {
                                 // All requested permissions are granted
                                  
                                } else {
                                    // At least one permission is denied
                                    Toast.makeText(MainActivity.this, "被拒绝", Toast.LENGTH_SHORT).show();
                                }
                            }
         });
                        
 ```
 
  * 11.android 8.0通知适配 不做是配的话你的通知是不会出现的  
  核心代码如下：
  
   ```
     String channelId = "chat";
            String channelName = "聊天消息";

            //重要等级
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);



            channelId = "push";
            channelName = "推送消息";
            importance = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importance);
  ```

* 12.自定义 CoordinatorLayout   Behavior行为  实现各种炫酷行为

  ![image](https://github.com/dust365/PersonDemo/blob/master/app/src/main/res/raw/my_behavior.gif)


  ```
    <TextView
        android:id="@+id/xuanfu_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="悬浮按钮"
        android:textColor="#ff33ff"
        app:layout_behavior="com.example.dust.persondemo.behavior.MyBehavior"
        app:layout_anchor="@id/appBar"
        app:layout_anchorGravity="start|bottom"
        />

  ```
  
 
 
~~过时的方法~~

 
 
 
