package com.busraciftlik.contacts.ex;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException() {
        super("The person already exists.");
    }
}
