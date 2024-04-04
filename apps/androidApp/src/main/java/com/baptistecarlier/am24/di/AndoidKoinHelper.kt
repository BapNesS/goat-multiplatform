package com.baptistecarlier.am24.di

import android.app.Application
import com.baptistecarlier.am24.data.di.dataAndroidModule
import com.baptistecarlier.am24.shared.data.di.dataSharedModule
import com.baptistecarlier.am24.shared.domain.di.sharedDomainModule
import com.baptistecarlier.am24.ui.di.appUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import org.koin.core.context.startKoin

context(Application)
internal fun startKoin(useSharedData: Boolean) {

    val dataModule = when {
        // KMP :
        useSharedData -> dataSharedModule
        // Android:
        else -> dataAndroidModule
    }

    startKoin {
        // Log Koin into Android logger
        val logsLevel: Level = Level.DEBUG
        androidLogger(logsLevel)
        // Reference Android context
        androidContext(this@Application)
        // Load modules
        val modulesList = buildList {
            add(appUiModule)
            add(dataModule)
            add(sharedDomainModule)
        }
        modules(modulesList)
    }
}