package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistance.entity.Movie;
import cinema.persistance.repository.MovieRepository;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping
	@ResponseBody //mettre la demande dans le corps 
	public List<Movie> allmovies() {
		return movieRepository.findAll();
	}
	
	@GetMapping("/{idMovie}")
	@ResponseBody
	public Optional<Movie> movieById(@PathVariable("") int idMovie) { //pathvariable suis le chemin indiqué dans GetMapping
		return	movieRepository.findById(idMovie);	
	}
	
	@GetMapping("/byTitle")
	@ResponseBody
	public Set<Movie> movieByTitle(@RequestParam ("t") String partialTitle) { 
		return	movieRepository.findByTitleContainingIgnoreCase(partialTitle);	
	}
		
	@GetMapping("/byYear")
	@ResponseBody
	public Set<Movie> movieByYearBetween(@RequestParam("y1") int firstYear, @RequestParam("y2") int lastYear) { 
		return	movieRepository.findByYearBetween(firstYear,lastYear);	
	}
	
	@PostMapping
	@ResponseBody //retransformer l'info en json pour etre lu en front
	public Movie addMovie(@RequestBody Movie movie) {
		Movie movieSaved = movieRepository.save(movie);
		movieRepository.flush();
		return movieSaved;
	}
	
	@PutMapping("/modify")
	@ResponseBody
	public Optional<Movie> modifyMovie(@RequestBody Movie movie) {
		var optMovie = movieRepository.findById(movie.getId_movie());
		// TODO : anywhere else
		optMovie.ifPresent(m -> {
			m.setTitle(movie.getTitle());
			m.setYear(movie.getYear());
			m.setDuration(movie.getDuration());
			m.setDirector(movie.getDirector());	
			movieRepository.flush();
		});			
		//		
		return optMovie;
	}

	
	@DeleteMapping("/{id}")
	@ResponseBody
	public Optional<Movie> deleteMovie(@PathVariable("id") int idMovie) {
		var movieToDelete = movieRepository.findById(idMovie);
		movieToDelete.ifPresent(m -> {
		movieRepository.delete(m);
		movieRepository.flush();		
		});
		return movieToDelete;
	}
}
