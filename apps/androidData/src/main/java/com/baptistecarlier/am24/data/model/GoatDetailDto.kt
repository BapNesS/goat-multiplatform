package com.baptistecarlier.am24.data.model

data class GoatDetailDto(
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