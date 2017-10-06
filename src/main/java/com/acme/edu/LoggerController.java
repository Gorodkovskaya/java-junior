package com.acme.edu;

import Exceptions.SavingException;
import com.acme.edu.messages.Message;

import java.io.IOException;

class LoggerController {
    private Message previousMessage;
    private Saver saver;

    LoggerController(Saver saver) {
        this.saver = saver;
    }

    void log(Message message) {
        if (previousMessage != null) {
            if (!previousMessage.isSameType(message)) {
                saver.save(previousMessage.flush());

            }
        }
        previousMessage = message;
        message.accumulate();
    }

    void stop() throws SavingException {
        saver.save(previousMessage.flush());
        previousMessage = null;
    }
}
