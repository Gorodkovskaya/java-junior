package com.acme.edu;

import com.acme.edu.messages.Message;

class LoggerController {
    private Message previousMessage;
    private Saver saver;

    LoggerController(Saver saver) {
        this.saver = saver;
    }

    void log(Message message) {
        if (previousMessage != null) {
            if (!previousMessage.sameType(message)) {
                saver.save(previousMessage.flush());
            }
        }
        previousMessage = message;
        message.accumulate();
    }

    void stop() {
        saver.save(previousMessage.flush());
        previousMessage = null;
    }
}
