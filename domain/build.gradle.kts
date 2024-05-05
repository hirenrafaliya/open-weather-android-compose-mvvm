plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.com.google.devtools.ksp)
    id("kotlinx-serialization")

}

android {
    namespace = "com.application.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildTypes {
        debug {

        }
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
}

dependencies {

    implementation(project(":data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.datastore.preferences)

}