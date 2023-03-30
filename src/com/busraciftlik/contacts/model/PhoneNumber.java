package com.busraciftlik.contacts.model;

import com.busraciftlik.contacts.enums.Type;

import java.io.Serializable;
import java.util.Objects;

public class PhoneNumber implements Serializable {
    private int id;
    private Type type;

    private String phoneNumber;

    public PhoneNumber(int id,String phoneNumber, Type type) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }
    public PhoneNumber(String phoneNumber, Type type) {
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
