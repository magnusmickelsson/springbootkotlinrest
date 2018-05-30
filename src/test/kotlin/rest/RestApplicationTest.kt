package rest

import com.jayway.restassured.RestAssured
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
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(
        classes = arrayOf(KotlinSpringApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestApplicationTest {
    val logger = LoggerFactory.getLogger(javaClass)

    @Value("\${local.server.port}")
    var port: Int = 0

    @Autowired
    private lateinit var repository: BlogEntryRepository

    @Before
    fun init() {
        RestAssured.port = port
    }

    @Test
    fun `'ping' should return 'PONG'`() {
        given().
        `when`()
            .get("ping").
        then()
            .statusCode(200)
            .body(equalTo("PONG"))
    }

    @Test
    fun `Should be able to create Blog Entry`() {
        val author = "Mickel"
        val headline = "Hello World!"
        val text = "Blog Entry Text"
        val entry = mapOf(
                "headline" to headline,
                "text" to text,
                "author" to author
        )
        val json = JSONObject()
        for ((k, v) in entry) {
            json.put(k, v)
        }

        given()
            .header("Content-Type", "application/json")
            .body(json.toString()).
        `when`()
            .post("/blogEntries").
        then()
            .statusCode(201) // assert CREATED http response code

        val blogEntries = repository.findAll()
        assertEquals(blogEntries.size, 1)
        val first = blogEntries.first()
        assertEquals(first.author, author)
        assertEquals(first.headline, headline)
        assertEquals(first.text, text)

        for (blogEntry in blogEntries){
            logger.info(blogEntry.toString())
        }
    }
}