package io.arpit.api

import io.arpit.api.services.ConduitAPI
import io.arpit.api.services.ConduitAuthAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ConduitClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api: ConduitAPI = retrofit.create(ConduitAPI::class.java)
    val authAPI: ConduitAuthAPI = retrofit.create(ConduitAuthAPI::class.java)
}