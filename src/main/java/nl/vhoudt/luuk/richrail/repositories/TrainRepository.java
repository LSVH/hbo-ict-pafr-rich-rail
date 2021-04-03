package nl.vhoudt.luuk.richrail.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import nl.vhoudt.luuk.richrail.domain.Train;

public interface TrainRepository extends CrudRepository<Train, Integer> {
    Optional<Train> findById(Integer id);
}
