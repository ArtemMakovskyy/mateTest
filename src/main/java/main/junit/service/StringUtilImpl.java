package main.junit.service;

import main.junit.exception.ValidationException;

public class StringUtilImpl {

    public String toUpperCase(String string) throws ValidationException {
        if (string== null){
            throw new ValidationException("String can't be null");
        }
        return string.toUpperCase();
    }
    public String toUpperCase2(String string) throws ValidationException {
        if (string== null){
            return null;
        }
        return string.toUpperCase();
    }
}
