package io.arpit.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.arpit.api.models.entities.UserSignIn

@JsonClass(generateAdapter = true)
data class SignInRequest(
    @Json(name = "user")
    val userSignIn: UserSignIn
)