package com.baptistecarlier.am24.shared.domain.di

import com.baptistecarlier.am24.shared.domain.interactor.detail.GetGoatDetailUc
import com.baptistecarlier.am24.shared.domain.interactor.list.GetGoatTeaserUc
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val sharedDomainModule = module {
    factoryOf(::GetGoatDetailUc)
    factoryOf(::GetGoatTeaserUc)
}

