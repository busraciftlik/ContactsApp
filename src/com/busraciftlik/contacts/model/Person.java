package com.busraciftlik.contacts.model;

import java.util.ArrayList;
import java.util.Set;

public class Person {
    private String firstName;
    private String lastName;
    private Set<PhoneNumber> phoneNumbers;
    private String mail;
    private ArrayList<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
}
