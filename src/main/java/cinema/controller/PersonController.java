package cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import cinema.persistance.entity.Person;

public class PersonController {
	
	@GetMapping
	public List<Person> addPerson (Person person) {
		//TODO
		return person;
	}
	

}
