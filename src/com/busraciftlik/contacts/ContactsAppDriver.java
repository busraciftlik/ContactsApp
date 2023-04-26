package com.busraciftlik.contacts;

import com.busraciftlik.contacts.dao.PersistDatabaseDao;
import com.busraciftlik.contacts.enums.Type;
import com.busraciftlik.contacts.model.Person;
import com.busraciftlik.contacts.model.PhoneNumber;

import java.io.*;
import java.util.List;


public class ContactsAppDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ContactsApp contactsApp = new ContactsApp();
//        contactsApp.start();

        test1();

    }

    public static void test() {
        PersistDatabaseDao persistDatabaseDao = new PersistDatabaseDao();
        PhoneNumber phoneNumber = new PhoneNumber(3, "066666", Type.MOBILE);
        Person person = new Person("Busra", "Ciftlik", phoneNumber);
        persistDatabaseDao.addPerson(person);
    }

    public static void test1() {
        PersistDatabaseDao persistDatabaseDao = new PersistDatabaseDao();
       // int id = 5;
        persistDatabaseDao.findByName("Ikram");
        List<Person> all = persistDatabaseDao.findAll();
        System.out.println(all);

    }

}
