package com.example.dust.persondemo.utils;

/**
 * Created by dust on 2017/12/13.
 * JNI　　测试
 */

public class JNIUtils {

    static {
        //名字注意，需要跟你的build.gradle ndk节点下面的名字一样
        System.loadLibrary("NameProvider");
    }
    public native String getName();



}
