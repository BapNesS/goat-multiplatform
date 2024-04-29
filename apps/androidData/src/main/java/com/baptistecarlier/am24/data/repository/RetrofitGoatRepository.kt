package com.baptistecarlier.am24.data.repository

import com.baptistecarlier.am24.data.mapper.GoatDetailMapper
import com.baptistecarlier.am24.data.mapper.GoatTeaserMapper
import com.baptistecarlier.am24.data.repository.service.GoatDatasourceService
import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.shared.domain.repository.GoatRepository

class RetrofitGoatRepository(
    private val goatDatasourceService: GoatDatasourceService
) : GoatRepository {

    // Mappers
    private val goatTeaserMapper = GoatTeaserMapper()
    private val goatDetailMapper = GoatDetailMapper()

    // Implementations
    override suspend fun getAllGoat(): Result<List<GoatTeaser>> = runCatching {
        goatDatasourceService
            .getAll()
            .mapNotNull(goatTeaserMapper::mapOrNull)
    }

    override suspend fun getGoat(id: String): GoatDetail? = runCatching {
        goatDatasourceService
            .getDetail(id)
            .let(goatDetailMapper::mapOrNull)
    }.getOrNull()
}