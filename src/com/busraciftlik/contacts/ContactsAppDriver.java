package com.busraciftlik.contacts;

import com.busraciftlik.contacts.model.Contacts;
import com.busraciftlik.contacts.model.Person;

public class ContactsAppDriver {
    public static void main(String[] args) {
        Person person = new Person("Büşra", "Çiftlik");
        Person person1 = new Person("Zehra", "Yılmaz");

        Contacts contacts = new Contacts();
        contacts.addPerson(person);
        contacts.addPerson(person1);
        contacts.addPerson(person);

        contacts.findAll();
        contacts.deletePerson(person);

    }
}
