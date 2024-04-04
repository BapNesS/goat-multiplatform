package com.baptistecarlier.am24.shared.data.mapper

import com.baptistecarlier.am24.shared.data.model.GoatTeaserDto
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser

internal class GoatTeaserMapper {

    fun mapOrNull(dto: GoatTeaserDto): GoatTeaser? {
        if (dto.id == null) return null
        if (dto.name == null) return null

        return GoatTeaser(dto.id, dto.name, dto.age, dto.breed, dto.url)
    }

}