#include <jni.h>
//#include <string>
#include <ctime>
#include <android/log.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/inotify.h>
#include "pthread.h"
#include "unistd.h"

#include <stdio.h>
#include "pthread.h"
#include "unistd.h"

#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>



using namespace std;


extern "C"{


#define LOG_TAG  "C_TAG"
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)



    int num ;

void* normalCallBack(void* data){
//    int i = (int) data;
//    LOGI("create thread form c++ i = %d",i);
//    pthread_exit(NULL);

//    while(1) {
//
//        num++;
//
//        if(num >= 5){
//            execlp("am", "am", "start", "--user", "0", "-a","android.intent.action.VIEW", "-d", "http://www.baidu.com",(char*)NULL);
//            num = 0;
//
//        }
//
//        LOGD("hello %d",num);
//        sleep(1);
//    }
}



    JNIEXPORT void JNICALL Java_com_example_emall_wpq_MainActivity_startMqtt(JNIEnv *env, jobject) {
        LOGD("hello1111");
//        pthread_t pthread;
//        pthread_create(&pthread, NULL, normalCallBack, (void *) 1);
    }


    JNIEXPORT jstring JNICALL Java_com_example_emall_wpq_MainActivity_stringFromJNI(JNIEnv *env, jobject) {
        time_t now = time(0);
        char* dt = ctime(&now);
        return env->NewStringUTF(dt);
    }





}
