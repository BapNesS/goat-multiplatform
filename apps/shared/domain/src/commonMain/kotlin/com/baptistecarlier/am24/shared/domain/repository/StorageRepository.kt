package com.baptistecarlier.am24.shared.domain.repository

interface StorageRepository {
    suspend fun getListMode(): Boolean
    suspend fun updateListMode(isList: Boolean)
}