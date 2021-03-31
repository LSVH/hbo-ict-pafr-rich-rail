package nl.vhoudt.luuk.richrail.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping("/train")
    public ResponseEntity<Object> create(@RequestBody Train train) {
        Train savedTrain = service.save(train);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTrain.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
