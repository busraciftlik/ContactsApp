package com.busraciftlik.contacts.ex;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(int id) {
        super("Contact with id = "+id +" not found");

    }
}

