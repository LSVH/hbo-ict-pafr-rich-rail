package nl.vhoudt.luuk.richrail.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TrainControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url;

    @BeforeEach
    void setupUrl() {
        this.url = "http://localhost:" + this.port + "/train";
    }

    @Test
    void canList() throws Exception {
        JSONArray actual = new JSONArray(restTemplate.getForEntity(this.url + "s", String.class).getBody());

        assertEquals(actual.getJSONObject(0).getString("title"), "Inter-City");
        assertEquals(actual.getJSONObject(0).getJSONArray("components").length(), 4);

        assertEquals(actual.getJSONObject(1).getString("title"), "Freighter");
        assertEquals(actual.getJSONObject(1).getJSONArray("components").length(), 4);
    }

    @Test
    Integer canCreate() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject expected = new JSONObject().put("title", "foo");
        HttpEntity<String> request = new HttpEntity<>(expected.toString(), headers);

        JSONObject actual = new JSONObject(restTemplate.postForEntity(this.url, request, String.class).getBody());

        assertEquals(expected.get("title"), actual.get("title"));
        assertNotNull(actual.get("id"));

        return (Integer) actual.get("id");
    }

    @Test
    void canRead() throws Exception {
        JSONObject actual = new JSONObject(restTemplate.getForEntity(this.url + "/1", String.class).getBody());

        assertEquals(actual.getInt("id"), 1);
        assertEquals(actual.getString("title"), "Inter-City");
    }

    @Test
    void canDelete() throws Exception {
        Integer id = this.canCreate();

        String beforeDelete = restTemplate.getForEntity(this.url + "/"+ id, String.class).getBody();
        assertEquals(id, new JSONObject(beforeDelete).get("id"));
    
        restTemplate.delete(this.url + "/" + id);

        String afterDelete = restTemplate.getForEntity(this.url + "/"+ id, String.class).getBody();
        assertThrows(JSONException.class, () -> {
            new JSONObject(afterDelete);
        });
    }
}
