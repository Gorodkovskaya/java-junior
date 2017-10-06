package com.acme.edu;

import com.acme.edu.exceptions.SavingException;

public interface Saver {
    void save(String message) throws SavingException;
}
