package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.enums.Type;

import java.io.Serializable;
import java.util.Objects;

public class PhoneNumber implements Serializable {
    private Type type;

    private String phoneNumber;

    public PhoneNumber(String phoneNumber, Type type) {
        this.phoneNumber = phoneNumber;
        this.type = type;
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
