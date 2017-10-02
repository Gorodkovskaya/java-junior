package com.acme.edu.messages;

import com.acme.edu.Prefix;

import static java.lang.Math.abs;

public class ByteMessage implements Message {
    private static final String PREFIX = Prefix.PRIMITIVE.value();
    private static int buffer = 0;
    private static int counter = 0;

    private byte value;

    public ByteMessage(byte value) {
        this.value = value;
    }

    @Override
    public void accumulate() {
        buffer += value;
        if (buffer < Byte.MIN_VALUE) {
            counter--;
            buffer -= Byte.MIN_VALUE;
        } else if (buffer > Byte.MAX_VALUE) {
            counter++;
            buffer -= Byte.MAX_VALUE;
        }
    }

    public String flush() {
        String result = this.format();
        reset();
        return result;
    }

    @Override
    public boolean sameType(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public String toString() {
        if (counter == 0) return String.valueOf(buffer);
        byte limit = counter > 0 ? Byte.MAX_VALUE : Byte.MIN_VALUE;

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
