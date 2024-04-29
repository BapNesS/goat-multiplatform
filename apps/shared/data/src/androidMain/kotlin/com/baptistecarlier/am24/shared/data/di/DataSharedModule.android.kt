package com.baptistecarlier.am24.shared.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.baptistecarlier.am24.shared.data.persistence.DataStoreMigrationFactory
import com.baptistecarlier.am24.shared.data.persistence.createDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataSharedAndroidModule = module {
    // DataStore
    single<DataStoreMigrationFactory> {
        DataStoreMigrationFactory(androidContext())
    }
    single<DataStore<Preferences>> {
        createDataStore(
            migrations = get<DataStoreMigrationFactory>().produceMigrations("OmgAppSettings"),
            producePath = { androidContext().filesDir.resolve("settings.preferences_pb").absolutePath },
        )
    }
}