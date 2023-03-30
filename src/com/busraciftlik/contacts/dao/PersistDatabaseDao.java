package com.busraciftlik.contacts.dao;

import com.busraciftlik.contacts.model.Person;

import java.sql.*;
import java.util.List;

public class PersistDatabaseDao implements CrudApi {
    private static final String INSERT_PHONE_NUMBER_FORMAT = "insert into phone_numbers values(%d,'%s','%s')";
    private static final String INSERT_PERSON_FORMAT = "insert into persons values(DEFAULT,'%s','%s',%d)";

    @Override
    public List<Person> findByName(String name) {

        return null;
    }

    @Override
    public Person deleteById(int id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        String sqlString = "select * from contacts";
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacts", "postgres", "12345");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                System.out.println(firstName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
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
