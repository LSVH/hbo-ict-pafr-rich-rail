package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import nl.vhoudt.luuk.richrail.domain.TypeAttribute;
import nl.vhoudt.luuk.richrail.repositories.TypeAttributeRepository;

@Log4j2
@Service
public class TypeAttributeService {
    @Autowired
    private TypeAttributeRepository repository;

    public TypeAttribute save(TypeAttribute entity) {
        log.info("Saving type attribute");
        return repository.save(entity);        
    }
}
