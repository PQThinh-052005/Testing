package com.example.testexcel.TestExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class UIMap {
    Properties properties;

    public UIMap(String FilePath) {
        try {
            FileInputStream locator = new FileInputStream(FilePath);
            properties = new Properties();
            properties.load(locator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public String getData(String ElementName) throws Exception {
        
        String data = properties.getProperty(ElementName);
        return data;
    }

    public By getLocator(String ElementName) throws Exception {
    
    String locator = properties.getProperty(ElementName);

    
    String locatorType = locator.split(":", 2)[0];
    String locatorValue = locator.split(":", 2)[1];

    
    if (locatorType.toLowerCase().equals("id")) {
        return By.id(locatorValue);
    } else if (locatorType.toLowerCase().equals("name")) {
        return By.name(locatorValue);
    } else if (locatorType.toLowerCase().equals("classname") || locatorType.toLowerCase().equals("class")) {
        return By.className(locatorValue);
    } else if (locatorType.toLowerCase().equals("tagname") || locatorType.toLowerCase().equals("tag")) {
        return By.tagName(locatorValue);
    } else if (locatorType.toLowerCase().equals("linktext")) {
        return By.linkText(locatorValue);
    } else if (locatorType.toLowerCase().equals("partiallinktext")) {
        return By.partialLinkText(locatorValue);
    } else if (locatorType.toLowerCase().equals("cssselector") || locatorType.toLowerCase().equals("css")) {
        return By.cssSelector(locatorValue);
    } else if (locatorType.toLowerCase().equals("xpath")) {
        return By.xpath(locatorValue);
    } else {
        throw new Exception("Locator type '" + locatorType + "' not defined!!");
    }
}
}
