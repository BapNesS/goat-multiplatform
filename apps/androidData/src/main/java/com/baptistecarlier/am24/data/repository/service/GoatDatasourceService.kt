package com.baptistecarlier.am24.data.repository.service

import com.baptistecarlier.am24.data.model.GoatDetailDto
import com.baptistecarlier.am24.data.model.GoatTeaserDto
import retrofit2.http.GET
import retrofit2.http.Path


interface GoatDatasourceService {

    companion object {
        const val BASE_URL = "https://bapness.github.io/goat-multiplatform/fakeApi/"
    }

    @GET("goat/all.json")
    suspend fun getAll(): List<GoatTeaserDto>

    @GET("goat/{id}/details.json")
    suspend fun getDetail(@Path("id") id: String): GoatDetailDto

}