package cinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistance.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
