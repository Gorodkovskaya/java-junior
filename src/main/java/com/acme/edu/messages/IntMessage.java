package com.acme.edu.messages;

import com.acme.edu.Prefix;

import static java.lang.Math.abs;

public class IntMessage implements Message {
    private static final String PREFIX = Prefix.PRIMITIVE.value();
    private static long buffer = 0;
    private static int counter = 0;

    private int value;

    public IntMessage(int value) {
        this.value = value;
    }

    @Override
    public void accumulate() {
        buffer += value;
        if (buffer < Integer.MIN_VALUE) {
            counter--;
            buffer -= Integer.MIN_VALUE;
        } else if (buffer > Integer.MAX_VALUE) {
            counter++;
            buffer -= Integer.MAX_VALUE;
        }
    }

    @Override
    public String flush() {
        String result = this.format();
        reset();
        return result;
    }

    @Override
    public boolean sameType(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public String toString() {
        if (counter == 0) return String.valueOf(buffer);
        int limit = counter > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < abs(counter); i++) {
            result.append(limit);
            result.append(System.lineSeparator());
        }
        result.append(buffer);

        return result.toString();
    }

    private String format() {
        return PREFIX + this.toString();
    }

    private void reset() {
        buffer = 0;
        counter = 0;
    }
}
