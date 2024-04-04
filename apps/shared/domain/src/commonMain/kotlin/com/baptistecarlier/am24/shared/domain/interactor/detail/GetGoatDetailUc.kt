package com.baptistecarlier.am24.shared.domain.interactor.detail

import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import com.baptistecarlier.am24.shared.domain.repository.GoatRepository

class GetGoatDetailUc(
    private val goatRepository: GoatRepository
) {
    suspend operator fun invoke(id: String): GoatDetail? =
        goatRepository.getGoat(id)
}