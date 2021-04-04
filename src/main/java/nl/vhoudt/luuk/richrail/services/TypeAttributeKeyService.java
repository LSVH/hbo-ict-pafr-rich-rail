package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import nl.vhoudt.luuk.richrail.common.NotFoundException;
import nl.vhoudt.luuk.richrail.domain.TypeAttributeKey;
import nl.vhoudt.luuk.richrail.repositories.TypeAttributeKeyRepository;

@Log4j2
@Service
public class TypeAttributeKeyService {
    @Autowired
    private TypeAttributeKeyRepository repository;

    public TypeAttributeKey save(TypeAttributeKey entity) {
        log.info("Saving type attribute key");
        return repository.save(entity);
    }
    
    public TypeAttributeKey findById(Integer id) {
        log.info("Searching for type attribute key with ID: " + id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }
}
