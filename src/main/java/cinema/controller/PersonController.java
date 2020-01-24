package cinema.controller;

import java.util.List;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;

import cinema.persistance.entity.Person;

public class PersonController {
	
	@GetMapping
	public List<Person> addPerson (Person person) {
		//TODO
		return person;
	}
	
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 9db3fe00e3c3902d492bbc9bfaa1990a49f1ce5f

import cinema.persistance.entity.Person;

public class PersonController {
	
	@PostMapping
	List<Person> addPerson (Person person) {
		//TODO
		return person;