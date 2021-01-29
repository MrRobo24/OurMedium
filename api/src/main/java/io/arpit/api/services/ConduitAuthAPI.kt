package io.arpit.api.services

import io.arpit.api.models.requests.SignInRequest
import io.arpit.api.models.requests.SignUpRequest
import io.arpit.api.models.requests.UserUpdateRequest
import io.arpit.api.models.responses.ProfileResponse
import io.arpit.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*
import sun.security.provider.certpath.OCSPResponse

interface ConduitAuthAPI {

    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponse>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest: UserUpdateRequest
    ): Response<UserResponse>

    @GET("profiles/{username}")
    suspend fun getProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @GET("profiles/{username}/follow")
    suspend fun followProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

}