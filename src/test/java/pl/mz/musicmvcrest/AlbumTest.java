package pl.mz.musicmvcrest;

import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pl.mz.musicmvcrest.domain.Album;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class AlbumTest {

    public static final String BASE_URL = "http://localhost:8080/api/v1/albums";
    @Test
    public void testGetAllAlbums() {
        when().
                get(BASE_URL).
                then().
                log().
                all().
                statusCode(200);
    }

    @Test
    public void testGetAlbumById(){
        when().
                get(BASE_URL + "/1").
                then().
                statusCode(200).
                assertThat().
                body("id", equalTo(1));
    }

    @Test
    public void testPostAlbum(){
        Album a1 = new Album();
        a1.setTitle("Smooth Jazz");
        a1.setRegion("World");
        a1.setReleasedDate(LocalDate.of(2023, 2, 25));

        given().
                contentType("application/json").
                body(a1).
                when().
                post(BASE_URL).
                then().
                statusCode(201).
                log().all();
    }

    @Test
    public void testPutAlbum() throws JSONException {
        JSONObject requestAlbum = new JSONObject();
        requestAlbum.put("id", 1);
        requestAlbum.put("title", "Smooth Jazz");
        requestAlbum.put("releasedDate", LocalDate.of(2023, 2, 25));

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestAlbum.toString())
                .when()
                .put(BASE_URL + "/1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testDeleteAlbum(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(BASE_URL + "/2")
                .then()
                .statusCode(204)
                .log().all();
    }
}
