package main.junit.service;

import main.junit.exception.ValidationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilImplTest {
    StringUtilImpl util = new StringUtilImpl();

    @Test
    void nullValue_NotOk()  {
        try {
            util.toUpperCase2(null);
        } catch (ValidationException e) {
            return;
        }
    }


    @Test
    void nullValue_NotOk2() {
        try {
            util.toUpperCase(null);
        } catch (ValidationException e) {
            return;
        }
        fail("ValidationException should be");
    }

    @Test
    void nullValue_NotOk3() {
        assertThrows(ValidationException.class, () -> {
            util.toUpperCase(null);
        });
    }


}