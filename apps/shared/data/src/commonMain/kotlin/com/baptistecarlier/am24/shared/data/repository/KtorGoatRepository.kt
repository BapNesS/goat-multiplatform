package com.baptistecarlier.am24.shared.data.repository

import com.baptistecarlier.am24.shared.data.mapper.GoatDetailMapper
import com.baptistecarlier.am24.shared.data.mapper.GoatTeaserMapper
import com.baptistecarlier.am24.shared.data.model.GoatDetailDto
import com.baptistecarlier.am24.shared.data.model.GoatTeaserDto
import com.baptistecarlier.am24.shared.data.network.KtorClient
import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.shared.domain.repository.GoatRepository
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorGoatRepository(
    private val ktorClient: KtorClient
) : GoatRepository {

    // URLs
    private val allUrl =
        "https://bapness.github.io/goat-multiplatform/fakeApi/goat/all.json"

    private fun detailUrl(id: String) =
        "https://bapness.github.io/goat-multiplatform/fakeApi/goat/$id/details.json"

    // Mappers
    private val goatTeaserMapper = GoatTeaserMapper()
    private val goatDetailMapper = GoatDetailMapper()

    // Implementations
    override suspend fun getAllGoat(): Result<List<GoatTeaser>> = runCatching {
        ktorClient.httpClient.get(allUrl)
            .body<List<GoatTeaserDto>>()
            .mapNotNull(goatTeaserMapper::mapOrNull)
    }

    override suspend fun getGoat(id: String): GoatDetail? = runCatching {
        ktorClient.httpClient.get(detailUrl(id))
            .body<GoatDetailDto>()
            .let(goatDetailMapper::mapOrNull)
    }.getOrNull()
}
