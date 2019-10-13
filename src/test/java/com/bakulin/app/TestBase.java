package com.bakulin.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public WebDriver driver;
    public Wait<WebDriver> wait;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized");
        // Create a new instance of the Firefox driver

        driver = new ChromeDriver(option);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}
