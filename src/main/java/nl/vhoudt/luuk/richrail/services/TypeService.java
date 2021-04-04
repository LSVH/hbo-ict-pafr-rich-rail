package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import nl.vhoudt.luuk.richrail.common.NotFoundException;
import nl.vhoudt.luuk.richrail.domain.Type;
import nl.vhoudt.luuk.richrail.repositories.TypeRepository;

@Log4j2
@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public Type save(Type entity) {
        log.info("Saving type");
        return repository.save(entity);
    }

    public Type findById(Integer id) {
        log.info("Searching for type with ID: " + id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }
}
