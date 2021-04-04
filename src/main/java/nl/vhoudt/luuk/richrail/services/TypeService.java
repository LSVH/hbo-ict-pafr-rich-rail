package nl.vhoudt.luuk.richrail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.vhoudt.luuk.richrail.common.NotFoundException;
import nl.vhoudt.luuk.richrail.domain.Type;
import nl.vhoudt.luuk.richrail.repositories.TypeRepository;

@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public Type save(Type entity) {
        return repository.save(entity);
    }

    public Type findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }
}
