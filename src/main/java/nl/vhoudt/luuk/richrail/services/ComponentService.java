package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.vhoudt.luuk.richrail.domain.Component;
import nl.vhoudt.luuk.richrail.repositories.ComponentRepository;

@Service
public class ComponentService {
    @Autowired
    private ComponentRepository repository;

    public Component save(Component entity) {
        return repository.save(entity);        
    }
}
