package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.enums.Type;

public class PhoneNumber {
    private Type type;

    private String phoneNumber;

    public PhoneNumber(String phoneNumber, Type type) {
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "type=" + type +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
