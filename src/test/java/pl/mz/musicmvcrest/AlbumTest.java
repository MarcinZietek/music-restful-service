package pl.mz.musicmvcrest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class AlbumTest {

    @Test
    public void testGetAllAlbums() {
        when().
                get("http://localhost:8080/api/v1/albums").
                then().
                log().
                all().
                statusCode(200);
    }

    @Test
    public void testGetAlbumById(){
        when().
                get("http://localhost:8080/api/v1/albums/1").
                then().
                statusCode(200).
                assertThat().
                body("id", equalTo(1));
    }
    
}
