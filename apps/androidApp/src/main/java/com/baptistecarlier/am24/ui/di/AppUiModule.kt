package com.baptistecarlier.am24.ui.di

import com.baptistecarlier.am24.ui.feature.detail.screen.DetailVM
import com.baptistecarlier.am24.ui.feature.list.screen.ListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appUiModule = module {
    viewModel { ListVM(get(), get(), get()) }
    viewModel { DetailVM(get(), get()) }
}

