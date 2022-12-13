package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.enums.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Person {

    private static int idCounter = 1;

    private int id = idCounter++;
    private String firstName;
    private String lastName;
    private Set<PhoneNumber> phoneNumbers;
    //private String mail;
    private ArrayList<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = new HashSet<>();
        this.addresses = new ArrayList<>();

    }



    public PhoneNumber addNewNumber(PhoneNumber newNumber) {
        phoneNumbers.add(newNumber);
        return newNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getLastName() {
        return lastName;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
