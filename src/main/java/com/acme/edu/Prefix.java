package com.acme.edu;

public enum Prefix {
    PRIMITIVE("primitive: " + System.lineSeparator()),
    CHAR("char: " + System.lineSeparator()),
    STRING("string: ");

    private String value;

    Prefix(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
