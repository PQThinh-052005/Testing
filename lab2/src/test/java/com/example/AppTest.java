package com.example;



import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testIsEventNumber2() {
        App demo1 = new App();
        boolean result = demo1.isEventNumber(2);
        assertTrue(result);

    }

    @Test
    public void testIsEventNumber4() {
        App demo1 = new App();
        boolean result = demo1.isEventNumber(4);
        assertTrue(result);
    }
}
