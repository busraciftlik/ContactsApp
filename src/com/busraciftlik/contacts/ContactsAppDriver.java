package com.busraciftlik.contacts;

import com.busraciftlik.contacts.enums.Type;
import com.busraciftlik.contacts.model.Contacts;
import com.busraciftlik.contacts.model.Person;
import com.busraciftlik.contacts.model.PhoneNumber;
import com.busraciftlik.contacts.service.ContactsService;

import java.util.List;
import java.util.Scanner;

public class ContactsAppDriver {
    public static void main(String[] args) {
        ContactsService contactsService = new ContactsService();
        contactsService.start();

    }

}
