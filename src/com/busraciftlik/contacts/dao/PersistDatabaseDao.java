package com.busraciftlik.contacts.dao;

import com.busraciftlik.contacts.model.Person;

import java.util.List;

public class PersistDatabaseDao implements CrudApi{
    @Override
    public List<Person> findByName(String name) {
        return null;
    }

    @Override
    public Person deleteById(int id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person addPerson(Person person) {
        System.out.println("Veritabanına kaydedildi");
        return null;
    }
}
