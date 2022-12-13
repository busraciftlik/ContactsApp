package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.ex.ContactNotFoundException;
import com.busraciftlik.contacts.ex.PersonAlreadyExistsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Contacts {
    private ArrayList<Person> contacts = new ArrayList<Person>();

    public Person addPerson(Person newPerson) {
        for(Person person : contacts){
            Set<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
            for(PhoneNumber phoneNumber : newPerson.getPhoneNumbers()){
                if (phoneNumbers.contains(phoneNumber)) {
                    throw new PersonAlreadyExistsException();
                }
            }
        }
        contacts.add(newPerson);
        return newPerson;
    }


    public Person deleteById(int id) {
        for (Person person : contacts) {
            if (person.getId() == id) {
                contacts.remove(person);
                return person;
            }
        }
        throw new ContactNotFoundException(id);
    }

    public List<Person> findAll() {
        return Collections.unmodifiableList(contacts);

    }

    public List<Person> findByName(String personName) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : contacts) {
            if (person.getFirstName().equals(personName)) {
                people.add(person);
            }
        }
        return people;
    }

    public Person findByPhoneNumber(String phoneNumber) {
        for (Person person : contacts) {
            if (person.getPhoneNumbers().equals(phoneNumber)) {
                return person;
            }
        }
        throw new ContactNotFoundException();
    }
}
