package cinema.persistence.entity.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cinema.persistance.entity.Movie;
import cinema.persistance.repository.MovieRepository;

@DataJpaTest
@AutoConfigureTestDatabase
class TestMovie {
	
	
	@Autowired
	MovieRepository repoMovie;

	@Test
	void test() {
		Movie movie = new Movie("Joker", 2019);
		//hbn.persist(movie); //sauvegarder le film dans la base de donnée
		repoMovie.save(movie);
	}
	
	

}
