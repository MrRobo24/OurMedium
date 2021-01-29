package io.arpit.api.services

import io.arpit.api.models.entities.UserReg
import io.arpit.api.models.requests.SignInRequest
import io.arpit.api.models.requests.SignUpRequest
import io.arpit.api.models.responses.ArticleResponse
import io.arpit.api.models.responses.ArticlesResponse
import io.arpit.api.models.responses.TagsResponse
import io.arpit.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

    @POST("users")
    suspend fun signUpUser(
        @Body userReg: SignUpRequest
    ): Response<UserResponse>

    @POST("users/login")
    suspend fun signInUser(
        @Body userSignIn: SignInRequest
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag: String? = null
    ): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>
}