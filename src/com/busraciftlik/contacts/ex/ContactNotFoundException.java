package com.busraciftlik.contacts.ex;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException() {
        super("Contact not found.");
    }
}

