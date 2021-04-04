package nl.vhoudt.luuk.richrail.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.vhoudt.luuk.richrail.domain.Type;
import nl.vhoudt.luuk.richrail.domain.TypeAttribute;
import nl.vhoudt.luuk.richrail.domain.TypeAttributeKey;
import nl.vhoudt.luuk.richrail.services.TypeAttributeKeyService;
import nl.vhoudt.luuk.richrail.services.TypeAttributeService;
import nl.vhoudt.luuk.richrail.services.TypeService;

@RestController
public class TypeAttributeController {
    @Autowired
    private TypeAttributeService service;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TypeAttributeKeyService keyService;

    @PostMapping(path = "/type-attribute")
    public ResponseEntity<Object> create(@RequestBody String req) {
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> json = jsonParser.parseMap(req);

        Type type = typeService.findById((Integer) json.get("type_id"));
        TypeAttributeKey key = keyService.findById((Integer) json.get("key_id"));
        TypeAttribute res = service.save(new TypeAttribute((String) json.get("value"), type, key));

        return ResponseEntity.ok(res);
    }
}
