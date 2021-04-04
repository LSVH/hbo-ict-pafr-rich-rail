package nl.vhoudt.luuk.richrail.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class TypeAttributeControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url;

    @BeforeEach
    void setupUrl() {
        this.url = "http://localhost:" + this.port + "/type-attribute";
    }

    @Test
    void canCreate() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject expected = new JSONObject()
            .put("type_id", 1)
            .put("key_id", 1)
            .put("value", "foo");
        HttpEntity<String> request = new HttpEntity<>(expected.toString(), headers);

        JSONObject actual = new JSONObject(restTemplate.postForEntity(this.url, request, String.class).getBody());

        assertEquals(expected.get("type_id"), actual.getJSONObject("type").getInt("id"));
        assertEquals(expected.get("key_id"), actual.getJSONObject("key").getInt("id"));
        assertEquals(expected.get("value"), actual.get("value"));
        assertNotNull(actual.get("id"));
    }
}
