#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_dust_persondemo_Activity_MainActivity_stringFromJNI(JNIEnv* env, jobject /* this */) {
    std::string hello = "我是JNI C++里面的代码 ";
    return env->NewStringUTF(hello.c_str());
}
