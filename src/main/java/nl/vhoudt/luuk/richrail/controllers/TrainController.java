package nl.vhoudt.luuk.richrail.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.vhoudt.luuk.richrail.domain.Train;
import nl.vhoudt.luuk.richrail.services.TrainService;

@RestController
public class TrainController {
    @Autowired
    private TrainService service;

    @GetMapping("/trains")
    public List<Train> list() {
        return service.findAll();
    }

    @GetMapping("/train/{id}")
    public Train read(@PathVariable String id) {
        return service.findById(Integer.parseInt(id));
    }

    @PostMapping(path = "/train")
    public ResponseEntity<Object> create(@RequestBody Train req) {
        Train res = service.save(req);

        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/train/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        service.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
