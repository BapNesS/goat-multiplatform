package com.baptistecarlier.am24

import android.app.Application
import com.baptistecarlier.am24.di.startKoin

class OmgApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO Android to KMP
        val useSharedData = true

        with(this) {
            startKoin(useSharedData)
        }
    }

}