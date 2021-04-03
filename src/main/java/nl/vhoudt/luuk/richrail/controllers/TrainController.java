package nl.vhoudt.luuk.richrail.controllers;

import java.util.List;
import java.util.Optional;

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
    public Optional<Train> read(@PathVariable String id) {
        return service.findById(Integer.parseInt(id));
    }

    @PostMapping(path = "/train")
    public ResponseEntity<Object> create(@RequestBody Train train) {
        Train savedTrain = service.save(train);

        return ResponseEntity.ok(savedTrain);
    }

    @DeleteMapping("/train/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(Integer.parseInt(id));
    }
}
