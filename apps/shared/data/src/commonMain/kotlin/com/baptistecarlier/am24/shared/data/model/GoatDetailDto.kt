package com.baptistecarlier.am24.shared.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class GoatDetailDto(
    val id: String,
    val fullName: String,
    val photoUrls: List<String>? = null,
    val breed: String? = null,
    val description: String? = null,
    val age: Int? = null,
    val temperament: String? = null,
    val skills: SkillsDto? = null,
    val diet: String? = null
)