package com.baptistecarlier.am24.data.repository

import com.baptistecarlier.am24.data.mapper.GoatDetailMapper
import com.baptistecarlier.am24.data.mapper.GoatTeaserMapper
import com.baptistecarlier.am24.data.model.GoatDetailDto
import com.baptistecarlier.am24.data.model.GoatTeaserDto
import com.baptistecarlier.am24.data.model.SkillsDto
import com.baptistecarlier.am24.shared.domain.model.GoatDetail
import com.baptistecarlier.am24.shared.domain.model.GoatTeaser
import com.baptistecarlier.am24.shared.domain.repository.GoatRepository

/**
 * It's a test class
 */
class FakeGoatRepository : GoatRepository {

    override suspend fun getAllGoat(): List<GoatTeaser> {
        val mapper = GoatTeaserMapper()
        return goatTeaserMock.mapNotNull { mapper.mapOrNull(it) }
    }

    override suspend fun getGoat(id: String): GoatDetail? {
        val mapper = GoatDetailMapper()
        return mapper.mapOrNull(goatDetailMock)
    }
}

private val goatTeaserMock = listOf(
    GoatTeaserDto(
        "1",
        "CapriSun",
        36,
        "Alpine",
        null
    ),
    GoatTeaserDto(
        "2",
        "Bêêêlinda",
        24,
        "Naine Nigériane",
        "https://media.4-paws.org/f/7/e/0/f7e032e9f37f07cbb02e28f061afa46d193002bd/VIER%20PFOTEN_2019-10-08_065-1336x1335-600x600.jpg",
    ),
)

private val goatDetailMock = GoatDetailDto(
    id = "1",
    fullName = "CapriSun la Magnifique",
    photoUrls = listOf(
        "https://media.4-paws.org/f/7/e/0/f7e032e9f37f07cbb02e28f061afa46d193002bd/VIER%20PFOTEN_2019-10-08_065-1336x1335-600x600.jpg",
        "https://media.npr.org/assets/img/2014/12/14/ap798386886673_custom-247a20518bf04f86ef4457d12939f46521c8751b.jpg",
    ),
    breed = "Alpine",
    description = "Une chèvre alpine gracieuse, avec une robe marron clair et de longues oreilles droites. Connue pour son tempérament aventureux.",
    age = 36,
    temperament = "Aventureux",
    skills = SkillsDto(milkProductivity = 0.8f, friendliness = 0.7f, humor = 0.9f),
    diet = "Herbe fraîche, foin, céréales et un complément minéral"
)
