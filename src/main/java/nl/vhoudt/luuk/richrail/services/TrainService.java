package nl.vhoudt.luuk.richrail.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.vhoudt.luuk.richrail.domain.Train;
import nl.vhoudt.luuk.richrail.repositories.TrainRepository;

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

    public Train save(Train entity) {
        return repository.save(entity);
    }
}
