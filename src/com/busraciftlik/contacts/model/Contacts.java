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
            System.out.println("New person added.");
            return newPerson;

        }
        throw new PersonAlreadyExists();
    }

    public void deletePerson(Person person) {
        contacts.remove(person);

    }

    public List<Person> findAll() {
        System.out.println("All List");
        return Collections.unmodifiableList(contacts);

    }

    public Person findByName(String personName) {
        for (Person person : contacts) {
            if (person.getFirstName().equals(personName)) {
                return person;
            }
        }
        throw new ContactNotFoundException();
    }

    public Person findByPhoneNumber(String phoneNumber){
        for(Person person : contacts){
            if(person.getPhoneNumbers().equals(phoneNumber)){
                return person;
            }
        }
        throw new ContactNotFoundException();
    }
}
