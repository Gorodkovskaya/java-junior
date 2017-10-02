package com.acme.edu.messages;

import com.acme.edu.Prefix;

public class StringMessage implements Message {
    private static final String PREFIX = Prefix.STRING.value();
    private static StringBuilder buffer = new StringBuilder();
    private static String previous;
    private static long counter = 1;

    private String value;

    public StringMessage(String value) {
        this.value = value;
    }

    @Override
    public void accumulate() {
        if (previous != null) {
            if (value.equals(previous)) {
                counter++;
            } else {
                appendPrevious();
            }
        }
        previous = value;
    }

    @Override
    public String flush() {
        String result = this.format();
        reset();
        return result;
    }

    @Override
    public boolean sameType(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public String toString() {
        appendPrevious();
        return buffer.toString();
    }

    private String format() {
        return PREFIX + this.toString();
    }

    private void reset() {
        buffer = new StringBuilder();
        previous = null;
        counter = 1;
    }

    private void appendPrevious() {
        buffer.append(System.lineSeparator());
        buffer.append(previous);

        if (counter > 1) { // will look like: "duplicatedString (x2)"
            buffer.append(" (x")
                    .append(counter)
                    .append(")");
            counter = 1;
        }
    }
}
