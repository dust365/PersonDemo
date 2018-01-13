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
 
 * 9.RxJava RxPermissions动态申请权限解决权限回调分割代码业务的问题
    
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
~~过时的方法~~
 
 
 
 
