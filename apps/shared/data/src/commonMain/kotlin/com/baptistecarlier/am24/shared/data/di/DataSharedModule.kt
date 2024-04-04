package com.baptistecarlier.am24.shared.data.di

import com.baptistecarlier.am24.shared.data.network.KtorClient
import com.baptistecarlier.am24.shared.data.repository.KtorGoatRepository
import com.baptistecarlier.am24.shared.domain.repository.GoatRepository
import org.koin.dsl.module

// MARK: DataShared for Ktor
val dataSharedModule = module {
    // KMP/Ktor stuff
    factory { KtorClient(false) }

    // Repository
    factory<GoatRepository> { KtorGoatRepository(get()) }
}