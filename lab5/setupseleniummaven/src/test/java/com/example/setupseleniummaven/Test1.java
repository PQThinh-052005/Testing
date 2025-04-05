package com.example.setupseleniummaven;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        try {
            String url = "https://www.google.com";
            String title_web = "Google";
            driver.get(url);
            String title = driver.getTitle();
            if (title.contentEquals(title_web)) {
                System.out.println("Test passed: " + title);
            } else {
                System.out.println("Test failed: " + title);
            }
        } finally {
            if (driver != null) {
                // Close the browser
                driver.quit();
            }
        }

    }
}
