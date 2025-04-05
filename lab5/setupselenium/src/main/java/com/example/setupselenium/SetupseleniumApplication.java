package com.example.setupselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SetupseleniumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SetupseleniumApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-4.30.0\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println("Page title: " + driver.getTitle());

        driver.quit();
	}
}
