package rest

import com.jayway.restassured.RestAssured
import com.jayway.restassured.RestAssured.`when`
import com.jayway.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.equalTo
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(
        classes = arrayOf(KotlinSpringApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestApplicationTest {
    val logger = LoggerFactory.getLogger(javaClass)

    @LocalServerPort
    var port: Int = 0

    @Autowired
    private lateinit var repository: BlogEntryRepository

    @Before
    fun init() {
        RestAssured.port = port
    }

    @Test
    fun `ping should return PONG`() {
        given().
                `when`().
                get("ping").
                then()
                .statusCode(200)
                .body(equalTo("PONG"))
    }

    @Test
    fun `Can create blog entry via post`() {
        val blogEntriesBefore = repository.findAll()
        assertEquals(blogEntriesBefore.size, 0)

        val json = JSONObject()
        val headline = "Headline"
        json.put("headline", headline)
        val text = "Random blog text"
        json.put("text", text)
        val author = "Magnus"
        json.put("author", author)

        given().
        header("Content-Type", "application/json").body(json.toString()).
        `when`().
        post("blogEntries").
        then()
        .statusCode(201) // Created

        val blogEntriesAfter = repository.findAll()
        assertEquals(blogEntriesAfter.size, 1)
        val blogEntry = blogEntriesAfter.first()
        assertEquals(blogEntry.headline, headline)
        assertEquals(blogEntry.text, text)
        assertEquals(blogEntry.author, author)
    }
}