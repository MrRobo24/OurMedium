package io.arpit.api

import io.arpit.api.models.entities.UserReg
import io.arpit.api.models.entities.UserSignIn
import io.arpit.api.models.requests.SignInRequest
import io.arpit.api.models.requests.SignUpRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {
    private val conduitClient = ConduitClient()

    @Test
    fun `GET articles`() {

        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `GET articles by author`() {

        runBlocking {
            val articles = conduitClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `GET articles by tag`() {

        runBlocking {
            val articles = conduitClient.api.getArticles(tag = "dragon")
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `POST users - sign up`() {
        runBlocking {
            val userReg = UserReg(
                email = "testemail${Random.nextInt(999, 9999)}@gmail.com",
                password = "LetMeIn_${Random.nextInt(9999, 999999)}",
                username = "rand_user_${Random.nextInt(99, 999)}"
            )
            val user = conduitClient.api.signUpUser(SignUpRequest(userReg))

            assertEquals(userReg.username, user.body()?.user?.username)
        }

    }


    @Test
    fun `POST users - sign in`() {
        runBlocking {
            val userSignIn = UserSignIn(
                email = "testemail1547@gmail.com",
                password = "LetMeIn_447852"
            )
            val user = conduitClient.api.signInUser(SignInRequest(userSignIn))

            assertEquals(userSignIn.email, user.body()?.user?.username)
        }
    }

    @Test
    fun `GET article by slug`() {
        runBlocking {
            val slug = "how-to-train-your-dragon"
            val article = conduitClient.api.getArticleBySlug(slug)

            assertEquals(slug, article.body()?.article?.slug)
        }
    }

    @Test
    fun `Get tags`() {
        runBlocking {
            val listTags = conduitClient.api.getTags()
            assertNotNull(listTags)
        }
    }

}