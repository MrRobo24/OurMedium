package io.arpit.ourmedium.repository

import io.arpit.api.ConduitClient
import io.arpit.api.services.ConduitAPI

object ArticlesRepository {
    val api = ConduitClient().api

    suspend fun getGlobalFeed() = api.getArticles()
}