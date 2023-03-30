package com.busraciftlik.contacts.service;

import com.busraciftlik.contacts.dao.CrudApi;
import com.busraciftlik.contacts.model.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ContactsService {
    private CrudApi databaseDao;

    public ContactsService(CrudApi databaseDao){
        this.databaseDao = databaseDao;
    }


    public List<Person> findByName(String name) {
        return databaseDao.findByName(name);
    }

    public Person deleteById(int id) {
        return databaseDao.deleteById(id);
    }

    public void listAllContacts() {

        List<Person> people = databaseDao.findAll();
        if (people.isEmpty()) {
            System.out.println("There is no contact in contact list");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    public Person addNewPerson(Person person) {
        return databaseDao.addPerson(person);
    }

    public void saveToHardDisk(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("contact.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(databaseDao);
            objectOutputStream.close();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }


}
