package cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import cinema.persistance.entity.Person;

public class PersonController {
	
	@PostMapping
	List<Person> addPerson (Person person) {
		//TODO
		return person;