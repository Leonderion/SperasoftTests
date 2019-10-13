package com.bakulin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends Page {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AuthenticationPage open() {

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }

    @FindBy(id = "email_create")
    public WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;
}
