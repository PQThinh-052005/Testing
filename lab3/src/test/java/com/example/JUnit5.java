package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnit5 {
    // BeforeAll là phương thức chỉ được chạy 1 lần trước khi bắt đầu tất cả các bài
    // kiểm tra
    @BeforeAll
    static void initAll() {
        System.out.println("Before All - Run before all test methods once");
    }

    // BeforeEach là phương thức được gọi trước mỗi bài kiểm tra.
    @BeforeEach
    void init() {
        System.out.println("Before Each - Run before each test method");
    }

    // @Test là phương thức kiểm nơi bên thực thi các bài kiểm tra cụ thể.
    // Với trường hợp này là trường hợp test có tên hiển thị là "First Test"
    @DisplayName("First Test")
    @Test
    void testMethod1() {
        System.out.println("Test Method 1");
    }

    // Đây là trường hợp 1 phương thức test bị vô hiệu hóa
    // Và nó sẽ không được khởi chạy khi thực thi toàn bộ test
    @Test
    @Disabled
    void testMethod2() {
        System.out.println("Test Method 2");
    }

    // Đây là 1 phương thức test được thực thi bình thường
    @Test
    void testMethod3() {
        System.out.println("Test Method 3");
    }

    // @AfterEach là 1 phương thức được gọi sau mỗi bài test
    // Đây là nơi bạn có thể dọn dẹp các tài nguyên hoặc đối tượng mà bạn dùng trong
    // bài test
    @AfterEach
    void tearDown() {
        System.out.println("After Each - Run after each test methods");
    }

    // @AfterAll là phương thức chỉ được gọi 1 lần sau khi tất cả các bài test được
    // hoàn thành
    // Và bạn có thể sử dụng phương thức này để giải phóng tài nguyên toàn cục như
    // jobManager
    @AfterAll
    static void tearDownAll() {
        System.out.println("After All - Run after all test methods once");
    }
}
