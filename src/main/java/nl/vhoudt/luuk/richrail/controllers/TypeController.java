package nl.vhoudt.luuk.richrail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.vhoudt.luuk.richrail.domain.Type;
import nl.vhoudt.luuk.richrail.services.TypeService;

@RestController
public class TypeController {
    @Autowired
    private TypeService service;

    @PostMapping(path = "/type")
    public ResponseEntity<Object> create(@RequestBody Type req) {
        Type res = service.save(req);

        return ResponseEntity.ok(res);
    }
}
