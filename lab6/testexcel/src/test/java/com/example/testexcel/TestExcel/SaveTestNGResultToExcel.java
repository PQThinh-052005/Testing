package com.example.testexcel.TestExcel;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SaveTestNGResultToExcel {
    WebDriver driver;
    public UIMap uimap;
    public UIMap datafile;
    public String workingDir;

    HSSFWorkbook workbook;
    HSSFSheet sheet;
    Map<String, Object[]> TestNGResults;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("TestNG Results");
        TestNGResults = new HashMap<>();

        uimap = new UIMap("src/main/resources/locator.properties");
        datafile = new UIMap("src/main/resources/data.properties");
    }

    @Test(description = "Opens the TestNG Demo Website for Login Test", priority = 1)
    public void launchWebsite() {
        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            TestNGResults.put("2", new Object[] {
                    1d, "Navigate to demo website", "Site gets opened successfully", "Pass"
            });
        } catch (Exception e) {
            TestNGResults.put("2", new Object[] {
                    1d, "Navigate to demo website", "Site failed to open", "Fail"
            });
            e.printStackTrace();
        }
    }

    @Test(description = "Fill the Login Details", priority = 2)
    public void fillLoginDetails() throws Exception {
        try {
            WebElement username = driver.findElement(uimap.getLocator("username"));
            username.sendKeys(datafile.getData("student"));

            WebElement password = driver.findElement(uimap.getLocator("password"));
            password.sendKeys(datafile.getData("Password123"));

            TestNGResults.put("3", new Object[] {
                    2d, "Fill Login form data (Username/Password)", "Login details are filled successfully", "Pass"
            });
        } catch (Exception e) {
            TestNGResults.put("3", new Object[] {
                    2d, "Fill Login form data (Username/Password)", "Login form filling failed", "Fail"
            });
            e.printStackTrace();
        }
    }

    @Test(description = "Perform Login", priority = 3)
    public void doLogin() throws Exception {
        try {
            WebElement loginButton = driver.findElement(uimap.getLocator("submit"));
            loginButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement username = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(uimap.getLocator("post-title")));

            Assert.assertEquals(username.getText(), "Logged In Successfully");

            TestNGResults.put("4", new Object[] {
                    3d, "Click Login and verify welcome message", "Login successful", "Pass"
            });
        } catch (Exception e) {
            TestNGResults.put("4", new Object[] {
                    3d, "Click Login and verify welcome message", "Login failed", "Fail"
            });
            e.printStackTrace();
        }
    }

    @AfterClass
    public void suiteTearDown() throws Exception {

        Set<String> keyset = TestNGResults.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = TestNGResults.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        try (FileOutputStream out = new FileOutputStream("TestNGResults.xls")) {
            workbook.write(out);
            System.out.println("TestNG Results saved to Excel file successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        driver.quit();
    }

}
