package com.baptistecarlier.am24.shared.data.mapper

import com.baptistecarlier.am24.shared.data.model.GoatDetailDto
import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import com.baptistecarlier.am24.shared.domain.model.Skills

internal class GoatDetailMapper {

    fun mapOrNull(dto: GoatDetailDto): GoatDetail? {
        if (dto.breed == null) return null
        if (dto.description == null) return null
        if (dto.age == null) return null
        if (dto.temperament == null) return null
        if (dto.diet == null) return null

        val skills = dto.skills
            ?.takeIf { it.milkProductivity != null || it.friendliness != null || it.humor != null }
            ?.let { Skills(it.milkProductivity, it.friendliness, it.humor) }

        return GoatDetail(
            id = dto.id,
            fullName = dto.fullName,
            photoUrls = dto.photoUrls?.filterNot { it.isBlank() }.orEmpty(),
            breed = dto.breed,
            description = dto.description,
            age = dto.age,
            temperament = dto.temperament,
            skills = skills,
            diet = dto.diet,
        )
    }

}