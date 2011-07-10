package com.security.scanner.alternative.scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestWebDriver {

    String urlToScan;
    WebDriver driver;

    public TestWebDriver (WebDriver driver)
    {
        this.driver = driver;
    }

    public Attacker attack (String urlToScan) {

        this.urlToScan = urlToScan;
        return new Attacker(this.urlToScan, this.driver);
    }

    public LoginBuilder login (String username, String password, String urlToScan)
    {
       return new LoginBuilder(driver, username, password, urlToScan);
    }

    public ValidationReport executionReportFor(String attackVector)
    {
        return new ValidationReport(this.driver, attackVector);
    }

    public void shutdown()
    {
        driver.close();
    }
}