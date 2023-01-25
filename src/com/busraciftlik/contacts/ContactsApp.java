package com.busraciftlik.contacts;

import com.busraciftlik.contacts.enums.Type;
import com.busraciftlik.contacts.model.Person;
import com.busraciftlik.contacts.model.PhoneNumber;
import com.busraciftlik.contacts.service.ContactsService;

import java.util.List;
import java.util.Scanner;

public class ContactsApp {
    private final ContactsService service;
    private final Scanner scanner = new Scanner(System.in);

    public ContactsApp(ContactsService service) {
        this.service = service;
    }
    public void start() {
        String message = "Please select the option you want to do: \n 1.Add new person \n 2.List all contacts \n 3.Delete by id \n 4.Find by name \n 5.Exit \n >";

        while (true) {
            System.out.print(message);
            int selection = scanner.nextInt();
            if (selection == 1) {
                addNewPerson();
            } else if (selection == 2) {
                service.listAllContacts();
            } else if (selection == 3) {
                service.deleteById(readIdFromConsole());
                System.out.println("Person deleted");
            } else if (selection == 4) {
                List<Person> byName = service.findByName(readNameFromConsole());
                byName.forEach(System.out::println);

            } else if (selection == 5) {
                break;
            }
        }
    }
    private String readNameFromConsole(){
        System.out.println("Enter name:");
        return scanner.next();
    }
    private int readIdFromConsole(){
        System.out.println("Please enter id:");
        return scanner.nextInt();
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
        Person person = new Person(firstName, lastName,phoneNumber1);
        person.addNewNumber(phoneNumber1);
        service.addNewPerson(person);
        System.out.println(person.toXmlString());
        test();

        // TODO: 28.11.2022 add phoneNumber

    }

    public void test(){
        String personXml = "<person><id>1</id><firstname>busra</firstname><lastname>ciftlik</lastname><phonenumber>05364897</phonenumber></person>";
        String str = "<firstname>";
        int beginIndex = personXml.indexOf(str)+str.length();
        int endIndex = personXml.indexOf("</firstname>");
        String firstName = personXml.substring(beginIndex, endIndex);
        System.out.println(firstName);
        str = "<lastname>";
        beginIndex = personXml.indexOf(str)+str.length();
        endIndex = personXml.indexOf("</lastname>");
        String lastName = personXml.substring(beginIndex, endIndex);
        System.out.println(lastName);
        str = "<phonenumber>";
        beginIndex = personXml.indexOf(str)+str.length();
        endIndex = personXml.indexOf("</phonenumber>");
        String phoneNumber = personXml.substring(beginIndex, endIndex);
        System.out.println(phoneNumber);
        PhoneNumber phoneNumber1 = new PhoneNumber(phoneNumber,Type.MOBILE);
        Person person = new Person(firstName,lastName,phoneNumber1);
        System.out.println(person.toString());


    }

}
