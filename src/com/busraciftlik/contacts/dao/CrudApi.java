package com.busraciftlik.contacts.dao;

import com.busraciftlik.contacts.model.Person;

import java.util.List;

public interface CrudApi{
    List<Person> findByName(String name);
    Person deleteById(int id);
    List<Person> findAll();
    Person addPerson(Person person);
}
