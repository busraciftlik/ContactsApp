package com.busraciftlik.contacts.dao;

import com.busraciftlik.contacts.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersistDatabaseDao implements CrudApi {
    private static final String INSERT_PHONE_NUMBER_FORMAT = "insert into phone_numbers values(%d,'%s','%s')";
    private static final String INSERT_PERSON_FORMAT = "insert into persons values(DEFAULT,'%s','%s',%d)";

    @Override
    public List<Person> findByName(String name) {
        ArrayList<Person> people = new ArrayList<>();
        String sqlStringFormat = "select * from persons where first_name ='%s'";
        String sqlString= String.format(sqlStringFormat,name);
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacts", "postgres", "12345");
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()){
                name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Person person = new Person(name,lastName,null);
                people.add(person);
                System.out.println(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }
    @Override
    public Person deleteById(int id) {
        String deleteFormat = "delete from persons where person_id = +%d";
        String sqlString = String.format(deleteFormat,id);
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacts", "postgres", "12345");
             Statement statement = connection.createStatement()){
            statement.execute(sqlString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        ArrayList<Person>people = new ArrayList<>();
        String sqlString = "select * from persons";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacts", "postgres", "12345");
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Person person = new Person(firstName,lastName,null);
                people.add(person);
                System.out.println(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people ;
    }

    @Override
    public Person addPerson(Person person) {
        // String sqlString = "insert into phone_numbers values(DEFAULT,"+ person.getPhoneNumber().getType()+","+person.getPhoneNumber().getPhoneNumber()+")";
        String insertPhoneNumberQuery = String.format(INSERT_PHONE_NUMBER_FORMAT, person.getPhoneNumber().getId(), person.getPhoneNumber().getType(), person.getPhoneNumber().getPhoneNumber());
        String insertPersonQuery = String.format(INSERT_PERSON_FORMAT, person.getFirstName(), person.getLastName(), person.getPhoneNumber().getId());
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacts", "postgres", "12345");
             Statement statement = connection.createStatement()) {
            statement.execute(insertPhoneNumberQuery);
            statement.execute(insertPersonQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
