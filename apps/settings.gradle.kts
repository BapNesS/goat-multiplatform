pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "OhMyGoat!"
include(
    // App
    ":androidApp",

    // Data in Android
    ":androidData",

    // Core in KMP
    ":shared",
    ":shared:domain",
    ":shared:data",
)
