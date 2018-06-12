package rest;

import com.jayway.restassured.RestAssured;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JavaSpringBootApplication.class}, webEnvironment = RANDOM_PORT)
@Transactional
public class RestApplicationTest {
    private static final transient Logger LOGGER = LoggerFactory.getLogger(RestApplicationTest.class);

    @LocalServerPort
    int port;

    @Autowired
    private BlogEntryRepository repository;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void pingReturnsPong() {
        given().
                when().
                get("ping").
                then().
                statusCode(200).
                body(equalTo("PONG"));
    }

    @Test
    public void canCreateBlogEntry() throws JSONException {
        List<BlogEntry> blogEntries = repository.findAll();
        assertEquals(blogEntries.size(), 0);
        final JSONObject json = new JSONObject();
        final String headline = "Headline";
        json.put("headline", headline);
        final String text = "Some random text";
        json.put("text", text);
        final String author = "Magnus";
        json.put("author", author);

        given().
                header("Content-Type", "application/json")
                .body(json.toString())
                .when().
                post("blogEntries")
                .then()
                .statusCode(201);

        blogEntries = repository.findAll();
        assertEquals(blogEntries.size(), 1);
        final BlogEntry blogEntry = blogEntries.get(0);
        assertEquals(blogEntry.getHeadline(), headline);
        assertEquals(blogEntry.getText(), text);
        assertEquals(blogEntry.getAuthor(), author);
    }
}