package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.vhoudt.luuk.richrail.domain.TypeAttribute;
import nl.vhoudt.luuk.richrail.repositories.TypeAttributeRepository;

@Service
public class TypeAttributeService {
    @Autowired
    private TypeAttributeRepository repository;

    public TypeAttribute save(TypeAttribute entity) {
        return repository.save(entity);        
    }
}
