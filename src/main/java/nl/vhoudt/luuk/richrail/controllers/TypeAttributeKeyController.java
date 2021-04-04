package nl.vhoudt.luuk.richrail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.vhoudt.luuk.richrail.domain.TypeAttributeKey;
import nl.vhoudt.luuk.richrail.services.TypeAttributeKeyService;

@RestController
public class TypeAttributeKeyController {
    @Autowired
    private TypeAttributeKeyService service;

    @PostMapping(path = "/type-attribute-key")
    public ResponseEntity<Object> create(@RequestBody TypeAttributeKey req) {
        TypeAttributeKey res = service.save(req);

        return ResponseEntity.ok(res);
    }
}
