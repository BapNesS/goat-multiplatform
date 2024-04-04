package com.baptistecarlier.am24.shared.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class SkillsDto(
    val milkProductivity: Float? = null,
    val friendliness: Float? = null,
    val humor: Float? = null
)