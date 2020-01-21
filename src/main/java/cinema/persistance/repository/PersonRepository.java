package cinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistance.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}