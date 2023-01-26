package main.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void demo() {
        boolean actualB = false;
        assertTrue(true);
        assertFalse(actualB);
        assertFalse(actualB,"Error it");
        int expected = 10 ;
        int actual = 10;
        assertEquals(expected,actual);
        assertEquals(expected,actual,"Error it");
        assertNotEquals(3,2);
        assertNotEquals(3,2,"ads");
        assertNull(null);
        assertNotNull(new String());
    }
}