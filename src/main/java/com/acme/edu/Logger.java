package com.acme.edu;

import javax.print.DocFlavor;

public class Logger {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";


    public static void log(int message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE + message);
    }

    public static void log(char message) {
        System.out.println(CHAR + message);
    }

    public static void log(String message) {
        System.out.println(STRING + message);
    }
}