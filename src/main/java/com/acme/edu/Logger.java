//
package com.acme.edu;

import static java.lang.Math.abs;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static String concat = "";
    private static long sum;
    private static long counter;
    private static boolean intActive;
    private static boolean byteActive;
    private static boolean stringActive;

    public static void log(int message) {
        checkActive();
        intActive = true;

        sum += message;
        if (sum > Integer.MAX_VALUE) {
            counter++;
        }

        if (sum < Integer.MIN_VALUE) {
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

    private static void checkActive() {
        if (byteActive) {
            if (counter > 0) {
                for (int i = 0; i < counter; i++) {
                    System.out.println(Byte.MAX_VALUE);
                }
                sum -= Byte.MAX_VALUE * counter;
            } else if (counter < 0) {
                counter = abs(counter);
                for (int i = 0; i < counter; i++) {
                    System.out.println(Byte.MIN_VALUE);
                }
                sum += Byte.MAX_VALUE * counter;
            }
            System.out.println(sum);
            resetState();
            return;
        }

        if (intActive) {
            if (counter > 0) {
                for (int i = 0; i < counter; i++) {
                    System.out.println(Integer.MAX_VALUE);
                }
                sum -= Integer.MAX_VALUE * counter;
            } else if (counter < 0) {
                counter = abs(counter);
                for (int i = 0; i < counter; i++) {
                    System.out.println(Integer.MIN_VALUE);
                }
                sum += Integer.MAX_VALUE * counter;
            }
            System.out.println(sum);
            resetState();
            return;
        }
    }

    private static void resetState() {
        intActive = false;
        byteActive = false;
        stringActive = false;

        concat = "";
        sum = 0;
        counter = 0;
    }
}