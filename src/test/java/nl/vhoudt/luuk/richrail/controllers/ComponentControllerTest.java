package nl.vhoudt.luuk.richrail.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ComponentControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url;

    @BeforeEach
    void setupUrl() {
        this.url = "http://localhost:" + this.port + "/component";
        restTemplate.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

    @Test
    void canCreate() throws Exception {
        Integer expected = 1;
        JSONObject actual = this.createDummyComponent(expected);

        assertEquals(expected, actual.get("spot"));
        assertNotNull(actual.get("id"));
    }

    @Test
    void canUpdateTrain() throws Exception {
        String putUrl = this.url + "/1/train/1";

        JSONObject actual = new JSONObject(restTemplate.patchForObject(putUrl, null, String.class));

        assertEquals("Inter-City", actual.get("title"));
        assertNotNull(actual);
    }

    @Test
    void canDelete() throws Exception {
        JSONObject expected = this.createDummyComponent(1);
        String resourceUrl = this.url + "/" + expected.getInt("id");

        restTemplate.delete(resourceUrl);
        JSONObject actual = new JSONObject(restTemplate.getForEntity(resourceUrl, String.class).getBody());

        assertNotEquals(expected, actual);
    }

    private JSONObject createDummyComponent(Integer spot) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject expected = new JSONObject().put("spot", spot).put("train_id", 1).put("type_id", 1);
        HttpEntity<String> request = new HttpEntity<>(expected.toString(), headers);

        return new JSONObject(restTemplate.postForEntity(this.url, request, String.class).getBody());
    }
}
