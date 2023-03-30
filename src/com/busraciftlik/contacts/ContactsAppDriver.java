package com.busraciftlik.contacts;

import com.busraciftlik.contacts.dao.PersistDatabaseDao;
import com.busraciftlik.contacts.enums.Type;
import com.busraciftlik.contacts.model.Person;
import com.busraciftlik.contacts.model.PhoneNumber;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactsAppDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ContactsApp contactsApp = new ContactsApp();
//        contactsApp.start();

       // findAll();
        test();





    }
    public static void test(){
        PersistDatabaseDao persistDatabaseDao = new PersistDatabaseDao();
        PhoneNumber phoneNumber = new PhoneNumber(3,"066666", Type.MOBILE);
        Person person = new Person("Busra","Ciftlik",phoneNumber);
        persistDatabaseDao.addPerson(person);
    }
    public static List<Person> findAll() {
        ArrayList<Person> people = new ArrayList<>();
        String sqlString = "select * from persons";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacts", "postgres", "12345");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()){
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int id = resultSet.getInt("person_id");
                Person person = new Person(firstName,lastName,null);
                people.add(person);
                System.out.println(firstName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

}
