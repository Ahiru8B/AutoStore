package com.ahiru8b.autostore.dao;

import org.springframework.data.repository.CrudRepository;

import com.ahiru8b.autostore.model.Person;

public interface PersonDao extends CrudRepository<Person, Integer> {

}
