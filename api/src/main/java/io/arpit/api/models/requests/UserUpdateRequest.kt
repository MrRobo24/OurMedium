package io.arpit.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.arpit.api.models.entities.UserUpdate

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
    @Json(name = "user")
    val userUpdate: UserUpdate
)