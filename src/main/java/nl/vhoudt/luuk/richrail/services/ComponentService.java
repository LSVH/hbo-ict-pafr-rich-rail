package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import nl.vhoudt.luuk.richrail.common.NotFoundException;
import nl.vhoudt.luuk.richrail.domain.Component;
import nl.vhoudt.luuk.richrail.repositories.ComponentRepository;

@Log4j2
@Service
public class ComponentService {
    @Autowired
    private ComponentRepository repository;

    public Component save(Component entity) {
        log.info("Saving component");
        return repository.save(entity);
    }

    public Component findById(Integer id) {
        log.info("Searching for component with ID: " + id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public void deleteById(Integer id) {
        log.info("Deleting component with ID: " + id);
        repository.deleteById(id);
    }
}
