package com.bakulin.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test (dataProvider = "data-provider", dataProviderClass = DataProviders.class) // Marking this method as part of the test
    public void createAnAccount(User User) throws InterruptedException {


        //Переход на главную страницу
        goToHomePage();
        //Переход на форму входа\регистрации
        goToSignIn();
        //Ввод почты для регистрации
        inputEmailForRegister(User.getEmail());
        //Thread.sleep(5000);
        //Указание гендерной принадлежности
        inputGender();
        //Фамилия
        inputFirstName(User.getFirstname());
        //Имя
        inputLastName(User.getLastname());
        //Пароль
        inputPasswd(User.getPassword());
        //Дата рождения
        inputDateOfBirth();

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        inputFirstNameAddres(User.getFirstname());
        inputLastNameAddres(User.getLastname());

        inputCompany(User.getCompany());

        inputAddress(User.getAddress());

        inputAddresstwo(User.getAddresstwo());

        inputCity(User.getCity());

        inputState();

        inputPostcode(User.getPostcode());

        inputCountry();

        inputOther(User.getAdditional());

        inputPhoneHome(User.getPhonehome());

        inputPhoneMobile(User.getPhonemobile());

        inputAlias(User.getAlias());

        register();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-heading")));
        String header = driver.findElement(By.cssSelector("h1.page-heading")).getText();
        // Verify that header equals "Selenium WebDriver"
        Assert.assertEquals(header, "MY ACCOUNT");
        //Thread.sleep(10000);
    }


    public void goToHomePage()
    {
        // Go to site
        driver.get("http://automationpractice.com/");
    }

    public void goToSignIn()
    {

        wait.until((WebDriver d) -> d.findElement(By.cssSelector("a.login"))).click();

        wait.until((WebDriver d) -> d.findElement(By.cssSelector("h1.page-heading")));
        String header = driver.findElement(By.cssSelector("h1.page-heading")).getText();

        // Verify that header equals "AUTHENTICATION"
        Assert.assertEquals(header, "AUTHENTICATION");
    }

    public void inputEmailForRegister(String email)
    {
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void inputGender() throws InterruptedException {
        //wait = new WebDriverWait(driver, 5, 5000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

        //driver.findElement(By.id("id_gender1")).click();

        myClickId("id_gender1");
    }

    public void inputFirstName(String fistName){
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys(fistName);
    }

    public void inputLastName(String lastName){
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
    }

    public void inputFirstNameAddres(String fistName){
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(fistName);
    }

    public void inputLastNameAddres(String lastName){
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    public void inputPasswd(String passwd){
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(passwd);
    }

    public void inputDateOfBirth(){

        new Select(driver.findElement(By.id("days"))).selectByValue("10");
        new Select(driver.findElement(By.id("months"))).selectByValue("5");
        new Select(driver.findElement(By.id("years"))).selectByValue("2000");
        /*
        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("2000");

         */
    }

    public void inputCompany(String company){
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys(company);
    }

    public void inputAddress(String address){
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys(address);
    }

    public void inputAddresstwo(String address){
        driver.findElement(By.id("address2")).clear();
        driver.findElement(By.id("address2")).sendKeys(address);
    }

    public void inputCity(String city){
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void inputState(){
        new Select(driver.findElement(By.id("id_state"))).selectByValue("2");

        /*
        driver.findElement(By.id("id_state")).sendKeys("Alaska");

         */
    }

    public void inputPostcode(String postcode){
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys(postcode);
    }

    public void inputCountry(){
        new Select(driver.findElement(By.id("id_country"))).selectByValue("21");

        /*
        driver.findElement(By.id("id_country")).sendKeys("United States");

         */
    }

    public void inputOther(String other){
        driver.findElement(By.id("other")).clear();
        driver.findElement(By.id("other")).sendKeys(other);
    }


    public void inputPhoneHome(String phone){
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys(phone);
    }

    public void inputPhoneMobile(String phone_mobile){
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys(phone_mobile);
    }

    public void inputAlias(String alias){
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys(alias);
    }

    public void register(){
        driver.findElement(By.id("submitAccount")).click();
    }

    public WebElement myClickId(String locator) throws InterruptedException {
        for (int count = 0; ; count++) {
            try {
                WebElement element = driver.findElement(By.id(locator));
                element.click();
                return element;
                //  Block of code to try
            } catch (Exception e) {
                if (count >= 50)
                {
                    throw e;
                }
                else
                {
                    Thread.sleep(100);
                }
                //  Block of code to handle errors
            }
        }
    }
}
