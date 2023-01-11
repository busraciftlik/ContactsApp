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
    private PhoneNumber phoneNumber;
    //private String mail;

    public Person(String firstName, String lastName, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }



    public PhoneNumber addNewNumber(PhoneNumber newNumber) {
        if(phoneNumber.equals(newNumber));
        return newNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
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
                ", phoneNumbers=" + phoneNumber +
                '}';
    }
}
