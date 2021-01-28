package io.arpit.api.services

import io.arpit.api.models.entities.UserReg
import io.arpit.api.models.requests.SignUpRequest
import io.arpit.api.models.responses.ArticlesResponse
import io.arpit.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ConduitAPI {

    @POST("users")
    suspend fun signUpUser(
        @Body userReg: SignUpRequest
    ): Response<UserResponse>

    @GET("articles")
    suspend

    fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag: String? = null
    ): Response<ArticlesResponse>
}