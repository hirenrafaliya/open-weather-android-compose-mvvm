// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.com.google.dagger.hilt.android) apply false
    alias(libs.plugins.com.google.devtools.ksp) apply false
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "1.9.10"
    alias(libs.plugins.androidLibrary) apply false
}