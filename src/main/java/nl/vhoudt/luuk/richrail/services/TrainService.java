package nl.vhoudt.luuk.richrail.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Train> findById(Integer id) {
        return repository.findById(id);
    }

    public Train save(Train entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
