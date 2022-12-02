package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.ex.ContactNotFoundException;
import com.busraciftlik.contacts.ex.PersonAlreadyExists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contacts {
    private ArrayList<Person> contacts = new ArrayList<Person>();

    public Person addPerson(Person newPerson) {
        if (!contacts.contains(newPerson)) {
            contacts.add(newPerson);
            return newPerson;

        }
        throw new PersonAlreadyExists();
    }


    public void deletePerson(Person person) {
        contacts.remove(person);

    }

    public List<Person> findAll() {
        return Collections.unmodifiableList(contacts);

    }
    public List<Person> findByName(String personName) {
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < contacts.size(); i++) {
            for (Person person : contacts) {
                if (person.getFirstName().equals(personName)) {
                    people.add(person);
               }
            }
            return people;
        }

        throw new ContactNotFoundException();
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
