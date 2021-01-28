package io.arpit.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.arpit.api.models.entities.UserReg

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "user")
    val user: UserReg
)