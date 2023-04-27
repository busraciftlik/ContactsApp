package com.busraciftlik.contacts.enums;

import java.io.Serializable;

public enum Type implements Serializable {
    HOME, MOBILE, WORK;

    public static Type getType(String typeString) {
        for (Type type : Type.values()) {
            if (type.name().equals(typeString)) {
                return type;
            }
        }
        return Type.MOBILE;
    }

}
