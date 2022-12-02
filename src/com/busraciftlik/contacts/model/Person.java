package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.enums.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Person {
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

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
