plugins {
    alias(libs.plugins.kmp)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }

    androidTarget()

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.baptistecarlier.am24.shared.data"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}
