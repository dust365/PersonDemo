


#include "com_example_dust_persondemo_utils_JNIUtils.h"
JNIEXPORT jstring JNICALL Java_com_example_dust_persondemo_utils_JNIUtils_getNameFromJNI
        (JNIEnv* env, jobject obj){

//如果是用C语言格式就用这种方式
//    return (*env)->NewStringUTF(env,"我是c++小王子");
    //如果是用C语言格式就用这种方式
    return (*env)->NewStringUTF(env,"getNameFromJNI 测试");
    //如果是c++使用该方式
//   return env->NewStringUTF((char *)"Kiss dream");

}

#include "com_example_dust_persondemo_utils_JNIUtils.h"
JNIEXPORT jstring JNICALL Java_com_example_dust_persondemo_utils_JNIUtils_stringFromJNI
        (JNIEnv* env, jobject obj){

//如果是用C语言格式就用这种方式
//    return (*env)->NewStringUTF(env,"我是c++小王子");
    //如果是用C语言格式就用这种方式
    return (*env)->NewStringUTF(env,"stringFromJNI  测试");
    //如果是c++使用该方式
//   return env->NewStringUTF((char *)"Kiss dream");

}