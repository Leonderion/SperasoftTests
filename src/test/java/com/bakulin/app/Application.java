package com.bakulin.app;

import com.bakulin.model.User;
import com.bakulin.page.AccountHeadPage;
import com.bakulin.page.AuthenticationPage;
import com.bakulin.page.GuestPage;
import com.bakulin.page.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Application {

    private WebDriver driver;

    private RegistrationPage registrationPage;
    private AccountHeadPage accountHeadPage;
    private AuthenticationPage authenticationPage;
    private GuestPage guestPage;

    public Application() {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized");

        driver = new ChromeDriver(option);
        registrationPage = new RegistrationPage(driver);
        accountHeadPage = new AccountHeadPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        guestPage = new GuestPage(driver);
    }

    public void quit() {

        driver.quit();
    }

    public void registerNewUser(User user) throws InterruptedException {

        guestPage.open();
        guestPage.goToAuthenticationPage();

        authenticationPage.emailInput.sendKeys(user.getEmail());
        authenticationPage.createAccountButton.click();

        registrationPage.inputGender(user.getGender());
        registrationPage.firstnameInput.sendKeys(user.getFirstname());
        registrationPage.lastnameInput.sendKeys(user.getLastname());
        registrationPage.passwordInput.sendKeys(user.getPassword());
        registrationPage.emailInput.clear();
        registrationPage.emailInput.sendKeys(user.getEmail());
        registrationPage.inputDateOfBirth(user.getDayOfBirth(), user.getMouthOfBirth(), user.getYearOfBirth());
        registrationPage.newsletterInput.click();
        registrationPage.offersInput.click();
        registrationPage.firstnameAddressInput.clear();
        registrationPage.firstnameAddressInput.sendKeys(user.getFirstname());
        registrationPage.lastnameAddressInput.clear();
        registrationPage.lastnameAddressInput.sendKeys(user.getLastname());
        registrationPage.companyInput.sendKeys(user.getCompany());
        registrationPage.addressInput.sendKeys(user.getAddress());
        registrationPage.addresstwoInput.sendKeys(user.getAddresstwo());
        registrationPage.cityInput.sendKeys(user.getCity());
        registrationPage.inputState(user.getState());
        registrationPage.postcodeInput.sendKeys(user.getPostcode());
        registrationPage.inputCountry(user.getCountry());
        registrationPage.otherInput.sendKeys(user.getAdditional());
        registrationPage.phoneHomeInput.sendKeys(user.getPhonehome());
        registrationPage.phoneMobileInput.sendKeys(user.getPhonemobile());
        registrationPage.aliasInput.clear();
        registrationPage.aliasInput.sendKeys(user.getAlias());
        registrationPage.registerButton.click();
    }

    public String getHeaderAfterLogon()
    {
        return accountHeadPage.getHeader();
    }
}
