package com.baptistecarlier.am24.shared.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class GoatTeaserDto(
    val id: String? = null,
    val name: String? = null,
    val age: Int? = null,
    val breed: String? = null,
    val url: String? = null,
)