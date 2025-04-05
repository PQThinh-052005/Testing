package com.example;

public class Calculator {

    // Phép cộng
    public int add(int a, int b) {
        return a + b;
    }

    // Phép trừ
    public int subtract(int a, int b) {
        return a - b;
    }

    // Phép nhân
    public int multiply(int a, int b) {
        return a * b;
    }

    // Phép chia
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero"); // Ném lỗi số học khi chia cho 0
        }
        return a / b;
    }
}

