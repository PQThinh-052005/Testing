package com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ParameterizedTestDemo {
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void testIsPositive(int number) {
        assertTrue(number > 0);
    }

    @Test
    void testWithAssertAll() {
        assertAll(
                "Group of assertions",
                () -> assertTrue("JUnit5".contains("Unit")),
                () -> assertEquals(2, 1 + 1),
                () -> assertFalse("Hello".isEmpty()));
    }

}
