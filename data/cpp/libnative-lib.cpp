#include <jni.h>
#include <string>

std::string getData(const std::string &key) {
    std::string app_secret = "Null";

    // API_KEY
    if (key == "1") app_secret = "YOUR-API-KEY-HERE";
    return app_secret;
}

extern "C"
jstring Java_com_application_data_util_SecretManager_getSecretKey(
        JNIEnv *env,
        jobject /* this */,
        jstring key) {
    const char *keyChars = env->GetStringUTFChars(key, 0);
    std::string keyStr(keyChars);
    env->ReleaseStringUTFChars(key, keyChars);

    std::string app_secret = getData(keyStr);

    return env->NewStringUTF(app_secret.c_str());
}