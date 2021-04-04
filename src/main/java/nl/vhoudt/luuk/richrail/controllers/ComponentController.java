package nl.vhoudt.luuk.richrail.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.vhoudt.luuk.richrail.domain.Component;
import nl.vhoudt.luuk.richrail.domain.Train;
import nl.vhoudt.luuk.richrail.domain.Type;
import nl.vhoudt.luuk.richrail.services.ComponentService;
import nl.vhoudt.luuk.richrail.services.TrainService;
import nl.vhoudt.luuk.richrail.services.TypeService;

@RestController
public class ComponentController {
    @Autowired
    private ComponentService service;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TypeService typeService;

    @PostMapping(path = "/component")
    public ResponseEntity<Object> create(@RequestBody String req) {
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> json = jsonParser.parseMap(req);

        Train train = trainService.findById((Integer) json.get("train_id"));
        Type type = typeService.findById((Integer) json.get("type_id"));
        Component res = service.save(new Component((Integer) json.get("spot"), train, type));

        return ResponseEntity.ok(res);
    }
}
