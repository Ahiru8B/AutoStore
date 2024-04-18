package com.ahiru8b.autostore.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahiru8b.autostore.model.Person;
import com.ahiru8b.autostore.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/person/")
@Slf4j
public class PersonApi {
	@Autowired
	private PersonService personService;

	@PostMapping
	public Person save(@RequestBody Person person) {
		log.info("Попытка сохранить person = {}", person);
		return personService.save(person);
	}

	@DeleteMapping("{id}")
	public Person delete(@PathVariable Integer id) {
		log.info("Попытка удалить person с id = {}", id);
		return personService.deleteById(id);
	}

	@GetMapping("{id}")
	public Person get(@PathVariable Integer id) {
		log.info("Попытка получить person с id = {}", id);
		return personService.findById(id);
	}

}
