package com.acme.edu;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";


    public static void log(int message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(char message) {
        System.out.println(CHAR + message);
    }
}