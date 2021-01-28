package io.arpit.api

import org.junit.Assert.assertNotNull
import org.junit.Test

class ConduitClientTests {
    private val conduitClient = ConduitClient()

    @Test
    fun `GET articles`() {
        val articles = conduitClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)
    }
}