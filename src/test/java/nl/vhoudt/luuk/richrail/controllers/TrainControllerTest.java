package nl.vhoudt.luuk.richrail.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.transaction.annotation.Transactional;

import nl.vhoudt.luuk.richrail.domain.Train;

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

        assertEquals(actual.length(), 2);
        
        assertEquals(actual.getJSONObject(0).getString("title"), "Inter-City");
        assertEquals(actual.getJSONObject(0).getJSONArray("components").length(), 4);

        assertEquals(actual.getJSONObject(1).getString("title"), "Freighter");
        assertEquals(actual.getJSONObject(1).getJSONArray("components").length(), 4);
    }

    // @Test
    void canCreate() throws Exception {
        Train expected = new Train("foo");
        HttpEntity<Train> request = new HttpEntity<>(expected);

        JSONObject actual = new JSONObject(restTemplate.postForEntity(this.url, request, String.class).getBody());

        assertNotNull(actual.get("id"));
        assertEquals(actual.get("title"), expected.getTitle());
    }
}
