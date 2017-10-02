package com.acme.edu.messages;

public interface Message {
    void accumulate();
    String flush();
    boolean isSameType(Message message);
}
