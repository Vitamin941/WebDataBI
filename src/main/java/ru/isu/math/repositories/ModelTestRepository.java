package ru.isu.math.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.isu.math.model.Model;

@Repository
public interface ModelTestRepository extends CrudRepository<Integer, Model> {
}
