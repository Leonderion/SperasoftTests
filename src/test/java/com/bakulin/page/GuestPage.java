package com.bakulin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GuestPage extends Page {

    public GuestPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GuestPage open() {

        driver.get("http://automationpractice.com/");
        return this;
    }

    public void goToAuthenticationPage()
    {
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("a.login"))).click();

        wait.until((WebDriver d) -> d.findElement(By.cssSelector("h1.page-heading")));
        String header = driver.findElement(By.cssSelector("h1.page-heading")).getText();

        // Verify that header equals "AUTHENTICATION"
        Assert.assertEquals(header, "AUTHENTICATION");
    }
}
