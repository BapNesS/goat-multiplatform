package com.baptistecarlier.am24.shared.domain.interactor.list

import com.baptistecarlier.am24.shared.domain.repository.StorageRepository

class GetListModeUc(
    private val storageRepository: StorageRepository
) {

    suspend operator fun invoke() = storageRepository.getListMode()

}