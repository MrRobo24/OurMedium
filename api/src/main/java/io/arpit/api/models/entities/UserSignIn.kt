package io.arpit.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserSignIn(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String

    
)