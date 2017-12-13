package com.example.dust.persondemo.utils;

/**
 * Created by dust on 2017/12/13.
 * JNI　　测试
 */

public class JNIUtils {

    static {
        //名字注意，需要跟你的build.gradle ndk节点下面的名字一样
        System.loadLibrary("native-lib1");
    }
    public  native String getNameFromJNI();


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public  native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }




}
