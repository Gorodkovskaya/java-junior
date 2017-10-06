package com.acme.edu;

import Exceptions.SavingException;
import com.acme.edu.messages.ByteMessage;
import com.acme.edu.messages.CharMessage;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.messages.StringMessage;

import java.io.IOException;

public class Logger {
    private final static LoggerController controller = new LoggerController(message -> {
        throw new SavingException();
    });

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void stop() {
        controller.stop();
    }
}