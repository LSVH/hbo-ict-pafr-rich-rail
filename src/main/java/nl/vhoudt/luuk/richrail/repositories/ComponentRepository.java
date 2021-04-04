package nl.vhoudt.luuk.richrail.repositories;

import org.springframework.data.repository.CrudRepository;

import nl.vhoudt.luuk.richrail.domain.Component;

public interface ComponentRepository extends CrudRepository<Component, Integer> {
}
