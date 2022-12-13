package com.busraciftlik.contacts.service;

import com.busraciftlik.contacts.model.Contacts;
import com.busraciftlik.contacts.model.Person;

import java.util.List;

public class ContactsService {
    private Contacts contacts = new Contacts();

    //public ContactsService(Contacts contacts){
    //    this.contacts = contacts;
    //}



    public List<Person> findByName(String name) {
        return contacts.findByName(name);
    }

    public Person deleteById(int id) {
        return contacts.deleteById(id);
    }

    public void listAllContacts() {

        List<Person> people = contacts.findAll();
        if (people.isEmpty()) {
            System.out.println("There is no contact in contact list");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    public Person addNewPerson(Person person) {
        return contacts.addPerson(person);
    }


}
