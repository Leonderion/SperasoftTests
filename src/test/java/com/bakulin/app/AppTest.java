package com.bakulin.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest {

    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized");
        // Create a new instance of the Firefox driver

        driver = new ChromeDriver(option);
    }

    @Test // Marking this method as part of the test
    public void gotoSite() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        // Go to site
        driver.get("http://automationpractice.com/");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.login")));
        driver.findElement(By.cssSelector("a.login")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-heading")));
        String header = driver.findElement(By.cssSelector("h1.page-heading")).getText();

        // Verify that header equals "AUTHENTICATION"
        Assert.assertEquals(header, "AUTHENTICATION");
        //Thread.sleep(10000);
    }
/*
    @Test // Marking this method as part of the test
    public void gotoSeleniumWikiPageFailure() {
        // Go to the Wikipedia home page
        driver.get("https://en.wikipedia.org/");
        // Find the text input element by its id and type "Selenium"
        driver.findElement(By.id("searchInput")).sendKeys("Selenium");
        // Click search button
        driver.findElement(By.id("searchButton")).click();
        // Get text from header of the Selenium page
        String header = driver.findElement(By.id("firstHeading")).getText();
        // Verify that header equals "Selenium WebDriver"
        Assert.assertEquals(header, "Selenium Webdriver");
    }
*/
    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}
