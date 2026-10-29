
plugins {
    id("com.android.application") version "8.6.1"
    id("org.jetbrains.kotlin.android") version "2.0.21"
}

android {
    namespace = "com.athems.arbcalculat"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.athems.arbcalculat"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
