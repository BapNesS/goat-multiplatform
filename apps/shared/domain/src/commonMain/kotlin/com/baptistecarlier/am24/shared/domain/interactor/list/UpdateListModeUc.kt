package com.baptistecarlier.am24.shared.domain.interactor.list

import com.baptistecarlier.am24.shared.domain.repository.StorageRepository

class UpdateListModeUc(
    private val storageRepository: StorageRepository
) {

    suspend operator fun invoke(isList: Boolean) =
        storageRepository.updateListMode(isList)

}