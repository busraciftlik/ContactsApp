package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.enums.Type;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber number = (PhoneNumber) o;
        return type == number.type && phoneNumber.equals(number.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, phoneNumber);
    }
}
