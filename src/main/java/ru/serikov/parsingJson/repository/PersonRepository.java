package ru.serikov.parsingJson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.serikov.parsingJson.entity.Person;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
