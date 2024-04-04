package com.baptistecarlier.am24.shared.domain.interactor.list

import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.shared.domain.repository.GoatRepository

class GetGoatTeaserUc(
    private val goatRepository: GoatRepository
) {

    suspend operator fun invoke(): List<GoatTeaser>? =
        goatRepository.getAllGoat()

}