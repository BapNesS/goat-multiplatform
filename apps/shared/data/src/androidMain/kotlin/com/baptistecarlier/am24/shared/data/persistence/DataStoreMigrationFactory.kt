package com.baptistecarlier.am24.shared.data.persistence;

import android.content.Context
import androidx.datastore.core.DataMigration
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences

actual class DataStoreMigrationFactory(private val context: Context) {

    actual fun produceMigrations(name: String): List<DataMigration<Preferences>> = listOf(
            SharedPreferencesMigration(context, name),
    )
}