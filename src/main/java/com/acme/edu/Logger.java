package com.acme.edu;

import javax.print.DocFlavor;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";


    public static void log(int message) {
        print(PRIMITIVE + message);
    }

    public static void log(byte message) {
        print(PRIMITIVE + message);
    }

    public static void log(char message) {
        print(CHAR + message);
    }

    public static void log(String message) {
        print(STRING + message);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}