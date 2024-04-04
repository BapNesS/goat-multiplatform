plugins {
    alias(libs.plugins.kmp)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }

    androidTarget()

    sourceSets {
        commonMain.dependencies {
            api(project(":shared:domain"))
            api(project(":shared:data"))
        }
        val androidMain by getting {
            dependsOn(commonMain.get())
        }
    }
}

android {
    namespace = "com.baptistecarlier.am24.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}