package com.ahiru8b.autostore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahiru8b.autostore.dao.PersonDao;
import com.ahiru8b.autostore.model.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;

	public Iterable<Person> findAll() {
		return personDao.findAll();
	}

	public Person save(Person person) {
		return personDao.save(person);
	}

	public Person deleteById(Integer id) {
		Optional<Person> person = personDao.findById(id);
		personDao.deleteById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}

	}

	public Person findById(Integer id) {
		Optional<Person> person = personDao.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}
}
