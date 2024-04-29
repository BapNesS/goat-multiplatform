package com.baptistecarlier.am24.shared.domain.repository

import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser

interface GoatRepository {
    suspend fun getAllGoat(): Result<List<GoatTeaser>>
    suspend fun getGoat(id: String): GoatDetail?
}
