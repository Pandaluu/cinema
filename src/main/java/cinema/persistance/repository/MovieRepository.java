package cinema.persistance.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistance.entity.Movie;
import cinema.persistance.entity.Person;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	Set<Movie> findByTitle(String title);
	Set<Movie> findByDirector(Person director);
	Set<Movie> findByDirectorNameEndingWith(String name);
	Set<Movie> findByYear(int year);
	Set<Movie> findByYearGreaterThan(int year2);
	Set<Movie> findByYearBetween(int StarttYear, int LastYear);
	Set<Movie> findByTitleAndYear(String title, int year3);

}
