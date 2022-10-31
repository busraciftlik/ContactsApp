package com.busraciftlik.contacts.ex;

public class PersonAlreadyExists extends RuntimeException {
    public PersonAlreadyExists() {
        super("The person already exists.");
    }
}
