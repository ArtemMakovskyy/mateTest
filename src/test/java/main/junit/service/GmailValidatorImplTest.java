package main.junit.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GmailValidatorImplTest {
    private EmailValidator emailValidator = new GmailValidatorImpl();

    @Test
    void containsGmailDomain_Ok() {
        String email = "valid@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertTrue(actual);
    }

    @Test
    void startWithNumber_NotOk() {
        String email = "456@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertFalse(actual);
    }

    @Test
    void startWithSymbol_NotOk() {
        String email = "$hello@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertFalse(actual);
    }

    @Test
    void containsSymbolsAndLater_Ok() {
        String email = "val456$id@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertTrue(actual);
    }

    @Test
    void nullValue_NotOk() {
        assertThrows(NullPointerException.class, () -> {
            emailValidator.isValid(null);
        });
    }

    @Test
    void nullValue_adOk() {
        String email = "val456$id@gmail.com";
        assertNotEquals(-1, email.lastIndexOf("@"), "need to past @");
    }

    @Test
    void existThreeSymbol_Ok() {
        String email = "abcd@gmail.com";
        assertNotEquals(-1, email.lastIndexOf("@"), "need to past @");
        assertTrue(email.lastIndexOf("@") > 3, "symbols must be more then three");
    }
}