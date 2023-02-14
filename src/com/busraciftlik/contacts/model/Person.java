package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.enums.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Person implements Serializable {

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
        if (phoneNumber.equals(newNumber)) ;
        return newNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
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

    public String toXmlString() {
        return "<person>" +
                "<id>"+id+"</id>" +
                "<firstname>"+firstName+"</firstname>" +
                "<lastname>"+lastName+"</lastname>" +
                "<phonenumber>"+phoneNumber+"</phonenumber>" +
                "</person>";
    }
}
