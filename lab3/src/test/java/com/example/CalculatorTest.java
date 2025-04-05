package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    // Phương thức này chạy trước mỗi bài kiểm thử
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    // Kiểm thử phép cộng
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should be 5");
    }

    // Kiểm thử phép trừ
    @Test
    public void testSubtract() {
        assertEquals(-1, calculator.subtract(2, 3), "2 - 3 should be -1");
    }

    // Kiểm thử phép nhân
    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should be 6");
    }

    // Kiểm thử phép chia
    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should be 2");

        // Trường hợp chia số 0 ném lỗi số học
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0), "Cannot divide by zero");
    }

}
