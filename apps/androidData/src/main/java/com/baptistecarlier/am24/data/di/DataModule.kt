package com.baptistecarlier.am24.data.di

import com.baptistecarlier.am24.data.repository.FakeGoatRepository
import com.baptistecarlier.am24.data.repository.RetrofitGoatRepository
import com.baptistecarlier.am24.data.repository.service.GoatDatasourceService
import com.baptistecarlier.am24.shared.domain.repository.GoatRepository
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

// MARK: Data (not shared for Retrofit)
val dataAndroidModule = module {
    // Android only/Retrofit stuff
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(GoatDatasourceService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<GoatDatasourceService> {
        get<Retrofit>().create(GoatDatasourceService::class.java)
    }

    // Repository
    // factory<GoatRepository> { FakeGoatRepository() }
    factory<GoatRepository> { RetrofitGoatRepository(get()) }
}

