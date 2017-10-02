package com.acme.edu.messages;

import com.acme.edu.Prefix;

import static java.lang.System.lineSeparator;

public class CharMessage implements Message {
    private static final String PREFIX = Prefix.CHAR.value();
    private static StringBuilder buffer = new StringBuilder();

    private char value;

    public CharMessage(char value) {
        this.value = value;
    }

    @Override
    public void accumulate() {
        buffer.append(value);
    }

    @Override
    public String flush() {
        return PREFIX + lineSeparator() + this.toString();
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
