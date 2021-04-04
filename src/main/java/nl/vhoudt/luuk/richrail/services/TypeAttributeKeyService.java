package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.vhoudt.luuk.richrail.domain.TypeAttributeKey;
import nl.vhoudt.luuk.richrail.repositories.TypeAttributeKeyRepository;

@Service
public class TypeAttributeKeyService {
    @Autowired
    private TypeAttributeKeyRepository repository;

    public TypeAttributeKey save(TypeAttributeKey entity) {
        return repository.save(entity);
    }
}
