package com.security.scanner.alternative.scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidationReport {

    WebDriver driver;
    String vector;
    public int numberOfInjections = 0;
    public int numberOfSuccesses = 0;
    public int numberOfFailures = 0;

    public ValidationReport(WebDriver driver, String attackVector)
    {
        this.driver = driver;
        this.vector = attackVector;
    }

    public void waitFor()
    {
        numberOfInjections++;
        try {
            Alert alertXss = driver.switchTo().alert();
            alertXss.dismiss();
            System.out.println("Attack succeeded for vector: " + vector + " on page " + driver.getCurrentUrl());
            numberOfSuccesses++;
        } catch (WebDriverException wde) {
            System.out.println("Attack failed for vector: " + vector + " on page " + driver.getCurrentUrl());
            numberOfFailures++;
        }
    }
}
