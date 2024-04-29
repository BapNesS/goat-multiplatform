package com.baptistecarlier.am24.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.baptistecarlier.am24.shared.domain.repository.StorageRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private object OnboardingKeys {
    val keyListMode = booleanPreferencesKey("keyListMode")
}

internal val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "OmgAppSettings")

class StorageRepositoryImpl(
    private val dataStore: DataStore<Preferences>,
) : StorageRepository {

    override suspend fun getListMode(): Boolean {
        return dataStore.data.map { it[OnboardingKeys.keyListMode] ?: true }.first()
    }

    override suspend fun updateListMode(isList: Boolean) {
        dataStore.edit { it[OnboardingKeys.keyListMode] = isList }
    }

}