package com.busraciftlik.contacts.dao;

import com.busraciftlik.contacts.enums.Type;
import com.busraciftlik.contacts.model.Person;
import com.busraciftlik.contacts.model.PhoneNumber;
import com.busraciftlik.contacts.util.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersistDatabaseDao implements CrudApi {
    private static final String INSERT_PHONE_NUMBER_FORMAT = "insert into phone_numbers values(%d,'%s','%s')";
    private static final String INSERT_PERSON_FORMAT = "insert into persons values(DEFAULT,'%s','%s',%d)";

    @Override
    public List<Person> findByName(String name) {
        ArrayList<Person> people = new ArrayList<>();
        String sqlStringFormat = "select pr.first_name,pr.last_name,pn.phone_number from persons pr inner join phone_numbers pn on pr.person_phone_number_id = pn.phone_number_id  where first_name = '%s'";
        String sqlString = String.format(sqlStringFormat, name);
        try (Connection connection = DataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                PhoneNumber phoneNumber1 = new PhoneNumber(phoneNumber, Type.MOBILE);
                Person person = new Person(name, lastName, phoneNumber1);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    public Person deleteById(int id) {
        String deleteFormat = "delete from persons where person_id = %d";
        String sqlString = String.format(deleteFormat, id);
        try (Connection connection = DataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sqlString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        ArrayList<Person> people = new ArrayList<>();
        String sqlString = "select pr.first_name,pr.last_name,pn.phone_type,pn.phone_number from persons pr inner join phone_numbers pn on pr.person_phone_number_id = pn.phone_number_id";
        try (Connection connection = DataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber1 = resultSet.getString("phone_number");
                PhoneNumber phoneNumber = new PhoneNumber(phoneNumber1, Type.getType(resultSet.getString("phone_type")));
                Person person = new Person(firstName, lastName, phoneNumber);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    public Person addPerson(Person person) {
        // String sqlString = "insert into phone_numbers values(DEFAULT,"+ person.getPhoneNumber().getType()+","+person.getPhoneNumber().getPhoneNumber()+")";
        String insertPhoneNumberQuery = String.format(INSERT_PHONE_NUMBER_FORMAT, person.getPhoneNumber().getId(), person.getPhoneNumber().getType(), person.getPhoneNumber().getPhoneNumber());
        String insertPersonQuery = String.format(INSERT_PERSON_FORMAT, person.getFirstName(), person.getLastName(), person.getPhoneNumber().getId());
        try (Connection connection = DataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(insertPhoneNumberQuery);
            statement.execute(insertPersonQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
