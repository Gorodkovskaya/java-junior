package com.acme.edu;

import static java.lang.Math.abs;

public class Logger { //sumtypedlogger
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static String concat = "";
    private static long buffer;
    private static long counter;
    private static boolean intActive;
    private static boolean byteActive;
    private static boolean stringActive;

    public static void log(int message) {
        checkActive();
        intActive = true;

        buffer += message;
        if (buffer > Integer.MAX_VALUE) {
            counter++;
        }

        if (buffer < Integer.MIN_VALUE) {
            counter--;
        }
    }

    public static void log(byte message) {
        checkActive();
        print(PRIMITIVE + message);
    }

    public static void log(char message) {
        checkActive();
        print(CHAR + message);
    }

    public static void log(String message) {
        checkActive();
        print(STRING + message);
    }

    private static void print(String message) {
        checkActive();
        System.out.println(message);
    }

    private static void printBuffer(int minConstraint, int maxConstraint) {
        if (counter > 0) {
            for (int i = 0; i < counter; i++) {
                System.out.println(maxConstraint);
            }
            buffer -= maxConstraint * counter;
        } else if (counter < 0) {
            counter = abs(counter);
            for (int i = 0; i < counter; i++) {
                System.out.println(minConstraint);
            }
            buffer += minConstraint * counter;
        }
        System.out.println(buffer);
    }

    private static void checkActive() {
        if (byteActive) {
            printBuffer(Byte.MIN_VALUE, Byte.MAX_VALUE);
            resetState();
            return;
        }

        if (intActive) {
            printBuffer(Integer.MIN_VALUE, Integer.MAX_VALUE);
            resetState();
            return;
        }
    }

    private static void resetState() {
        intActive = false;
        byteActive = false;
        stringActive = false;

        concat = "";
        buffer = 0;
        counter = 0;
    }
}