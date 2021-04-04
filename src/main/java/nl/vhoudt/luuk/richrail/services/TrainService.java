package nl.vhoudt.luuk.richrail.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import nl.vhoudt.luuk.richrail.common.NotFoundException;
import nl.vhoudt.luuk.richrail.domain.Train;
import nl.vhoudt.luuk.richrail.repositories.TrainRepository;

@Log4j2
@Service
public class TrainService {
    @Autowired
    private TrainRepository repository;

    public List<Train> findAll() {
        List<Train> trains = new ArrayList<Train>();

        for (Train train : repository.findAll()) {
            trains.add(train);
        }

        return trains;
    }

    public Train findById(Integer id) {
        log.info("Searching for train with ID: " + id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Train save(Train entity) {
        log.info("Saving train");
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        log.info("Deleting train with ID: " + id);
        repository.deleteById(id);
    }
}
