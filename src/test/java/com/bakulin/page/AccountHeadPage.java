package com.bakulin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountHeadPage extends Page{

    public AccountHeadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountHeadPage open() {

        driver.get("http://automationpractice.com/index.php?controller=my-account");
        return this;
    }

    public String getHeader() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-heading")));
        String header = driver.findElement(By.cssSelector("h1.page-heading")).getText();

        return  header;
    }

    public void logout() {
        if (driver.findElements(By.cssSelector("a.logout")).size() > 0) {
            driver.findElement(By.cssSelector("a.logout")).click();
            wait.until((WebDriver d) -> d.findElement(By.id("SubmitCreate")));
        }
    }
}
