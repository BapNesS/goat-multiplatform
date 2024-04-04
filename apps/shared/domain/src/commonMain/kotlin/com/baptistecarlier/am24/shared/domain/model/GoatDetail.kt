package com.baptistecarlier.am24.shared.domain.model

data class GoatDetail(
    val id: String,
    val fullName: String,
    val photoUrls: List<String>,
    val breed: String,
    val description: String,
    val age: Int,
    val temperament: String,
    val skills: Skills?,
    val diet: String
)