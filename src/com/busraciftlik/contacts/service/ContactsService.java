package com.busraciftlik.contacts.service;

import com.busraciftlik.contacts.enums.Type;
import com.busraciftlik.contacts.model.Contacts;
import com.busraciftlik.contacts.model.Person;
import com.busraciftlik.contacts.model.PhoneNumber;

import java.util.List;
import java.util.Scanner;

public class ContactsService {
    private final Scanner scanner = new Scanner(System.in);
    private Contacts contacts = new Contacts();

    //public ContactsService(Contacts contacts){
    //    this.contacts = contacts;
    //}

    public void start() {
        String message = "Please select the option you want to do: \n 1.Add new person \n 2.List all contacts \n 3.Delete by name \n 4.Find by name \n 5.Exit \n >";

        while (true) {
            System.out.print(message);
            int selection = scanner.nextInt();
            if (selection == 1) {
                addNewPerson();
                System.out.println("Person added");
            } else if (selection == 2) {
                listAllContacts();
            } else if (selection == 3) {
                //deleteByName();
                System.out.println("Person deleted");
            } else if (selection == 4) {
                findByName();
            } else if (selection == 5) {
                break;
            }

        }

    }

    private void findByName() {
        System.out.println("Please enter a name:");
        String name = scanner.next();
        List<Person> byName = contacts.findByName(name);
        System.out.println(byName);
    }

    //private void deleteByName() {


    //}

    private void listAllContacts() {

        List<Person> people = contacts.findAll();
        if (people.isEmpty()) {
            System.out.println("There is no contact in contact list");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    private void addNewPerson() {
        System.out.println(" Please enter first name:");
        String firstName = scanner.next();
        System.out.println(" Please enter last name:");
        String lastName = scanner.next();
        System.out.println("Please enter phone number:");
        String phoneNumber = scanner.next();
        System.out.println("Please enter phone type:");
        String type = scanner.next();
        Type typeEnum = type.equalsIgnoreCase("mobile") ? Type.MOBILE : Type.HOME;
        PhoneNumber phoneNumber1 = new PhoneNumber(phoneNumber, typeEnum);
        Person person = new Person(firstName, lastName);
        person.addNewNumber(phoneNumber1);

        // TODO: 28.11.2022 add phoneNumber
        contacts.addPerson(person);


    }
}
