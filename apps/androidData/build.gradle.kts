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
    // implementation(libs.androidx.core.ktx)
    // implementation(libs.androidx.appcompat)

    // Retrofit
    implementation(libs.retrofit2.retrofit)
    implementation(libs.converter.gson)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    // Shared
    api(project(":shared:domain"))
}