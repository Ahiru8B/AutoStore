package com.ahiru8b.autostore.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ahiru8b.autostore.model.Person;

@SpringBootTest
class PersonDaoTest {

	@Autowired
	private PersonDao personDao;

	@Test
	void initTest() {
		assertNotNull(personDao);
	}

	@Test
	void saveTest() {
		Person person = new Person();
		person.setName("Петр");
		person.setSurname("Иванов");
		person.setPatronymic("Петрович");
		person.setNumber("+75554383355");
		personDao.save(person);
		assertEquals(person, personDao.findById(1).get());
	}
}
