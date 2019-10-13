package com.bakulin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage extends Page {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage open() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        return this;
    }

    @FindBy(id = "customer_firstname")
    public WebElement firstnameInput;

    @FindBy(id = "customer_lastname")
    public WebElement lastnameInput;

    @FindBy(id = "firstname")
    public WebElement firstnameAddressInput;

    @FindBy(id = "lastname")
    public WebElement lastnameAddressInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "company")
    public WebElement companyInput;

    @FindBy(id = "address1")
    public WebElement addressInput;

    @FindBy(id = "address2")
    public WebElement addresstwoInput;

    @FindBy(id = "newsletter")
    public WebElement newsletterInput;

    @FindBy(id = "optin")
    public WebElement offersInput;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "postcode")
    public WebElement postcodeInput;

    @FindBy(id = "other")
    public WebElement otherInput;

    @FindBy(id = "phone")
    public WebElement phoneHomeInput;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobileInput;

    @FindBy(id = "alias")
    public WebElement aliasInput;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;

    public void waitPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id_gender1")));
    }

    public void inputGender(String gender) throws InterruptedException {
        if (gender.equals("Mr")) {
            wait.until((WebDriver d) -> d.findElement(By.id("id_gender1"))).click();
            //myClickId("id_gender1");
        }
        else if (gender.equals("Mrs")) {
            wait.until((WebDriver d) -> d.findElement(By.id("id_gender2"))).click();
            //myClickId("id_gender2");
        }
    }

    public void inputDateOfBirth(String day, String mouth, String year){
        new Select(driver.findElement(By.id("days"))).selectByValue(day);
        new Select(driver.findElement(By.id("months"))).selectByValue(mouth);
        new Select(driver.findElement(By.id("years"))).selectByValue(year);
    }

    public void inputState(String state){
        new Select(driver.findElement(By.id("id_state"))).selectByValue(state);
    }

    public void inputCountry(String country){
        new Select(driver.findElement(By.id("id_country"))).selectByValue(country);
    }

    public WebElement myClickId(String locator) throws InterruptedException {
        for (int count = 0; ; count++) {
            try {
                WebElement element = driver.findElement(By.id(locator));
                element.click();
                return element;
            } catch (Exception e) {
                if (count >= 50)
                {
                    throw e;
                }
                else
                {
                    Thread.sleep(100);
                }
            }
        }
    }
}
