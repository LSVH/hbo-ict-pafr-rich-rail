package nl.vhoudt.luuk.richrail.repositories;

import org.springframework.data.repository.CrudRepository;

import nl.vhoudt.luuk.richrail.domain.Type;

public interface TypeRepository extends CrudRepository<Type, Integer> {
}
