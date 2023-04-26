package com.busraciftlik.contacts.dao;

import com.busraciftlik.contacts.ex.ContactNotFoundException;
import com.busraciftlik.contacts.ex.PersonAlreadyExistsException;
import com.busraciftlik.contacts.model.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactInMemoryDao implements CrudApi, Serializable {
    private ArrayList<Person> contacts = new ArrayList<Person>();

    @Override
    public Person addPerson(Person newPerson) {
        for (Person person : contacts) {
            if (person.getPhoneNumber().equals(newPerson.getPhoneNumber())) {
                throw new PersonAlreadyExistsException();
            }
        }
        contacts.add(newPerson);
        return newPerson;
    }

    @Override
    public Person deleteById(int id) {
        for (Person person : contacts) {
            if (person.getId() == id) {
                contacts.remove(person);
                return person;
            }
        }
        throw new ContactNotFoundException(id);
    }

    @Override
    public List<Person> findAll() {
        return Collections.unmodifiableList(contacts);

    }

    @Override
    public List<Person> findByName(String personName) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : contacts) {
            if (person.getFirstName().equals(personName)) {
                people.add(person);
            }
        }
        return people;
    }

//    public Person findByPhoneNumber(String phoneNumber) {
//        for (Person person : contacts) {
//            if (person.getPhoneNumber().equals(phoneNumber)) {
//                return person;
//            }
//        }
//        throw new ContactNotFoundException();
//    }
}
