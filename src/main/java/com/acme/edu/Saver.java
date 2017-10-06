package com.acme.edu;

import Exceptions.SavingException;

public interface Saver {
    void save(String message) throws SavingException;
}
