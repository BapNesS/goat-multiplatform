plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.baptistecarlier.am24.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Retrofit
    implementation(libs.retrofit2.retrofit)
    implementation(libs.converter.gson)

    // DataStore (KMP compatible lib)
    implementation(libs.androidx.datastore)
    implementation(libs.androidx.datastore.preferences)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)

    // Shared
    api(project(":shared:domain"))
}