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
            implementation(project(":shared:domain"))

            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)

            api(libs.ktor.client.core)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.client.logging)
            api(libs.ktor.serialization.json)
            implementation(libs.ktor.client.contentNegociation)

            // DataStore (KMP compatible lib)
            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.preferences)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation(libs.koin.android)
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
