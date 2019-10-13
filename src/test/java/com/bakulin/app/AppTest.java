package com.bakulin.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.sql.Time;
import java.util.Date;
import org.testng.annotations.Test;

public class AppTest {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized");
        // Create a new instance of the Firefox driver

        driver = new ChromeDriver(option);
    }

    public void goToHomePage()
    {
        // Go to site
        driver.get("http://automationpractice.com/");
    }

    public void goToSignIn()
    {
        wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.login")));
        driver.findElement(By.cssSelector("a.login")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-heading")));
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
        wait = new WebDriverWait(driver, 5, 5000);
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
        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("2000");
    }

    public void inputCompany(String company){
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys(company);
    }

    public void inputAddress(String address){
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys(address);
    }

    public void inputCity(String city){
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void inputState(){
        driver.findElement(By.id("id_state")).sendKeys("Alaska");
    }

    public void inputPostcode(String postcode){
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys(postcode);
    }

    public void inputCountry(){
        driver.findElement(By.id("id_country")).sendKeys("United States");
    }

    public void inputOther(String other){
        driver.findElement(By.id("other")).clear();
        driver.findElement(By.id("other")).sendKeys(other);
    }


    public void inputPhone(String phone){
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

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        Date date = new Date();
        String email = date.toString().replace(' ', '_').replace(':', '_') + "@test.test";
        return new Object[][] { { email } };
    }

    @Test (dataProvider = "data-provider") // Marking this method as part of the test
    public void createAnAccount(String email) throws InterruptedException {
        //Переход на главную страницу
        goToHomePage();
        //Переход на форму входа\регистрации
        goToSignIn();
        //Ввод почты для регистрации
        inputEmailForRegister(email);
        //Thread.sleep(5000);
        //Указание гендерной принадлежности
        inputGender();
        //Фамилия
        inputFirstName("Фамилия");
        //Имя
        inputLastName("Имя");
        //Пароль
        inputPasswd("Пароль");
        //Дата рождения
        inputDateOfBirth();

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        inputFirstNameAddres("Фамилия");
        inputLastNameAddres("Имя");

        inputCompany("Компания");

        inputAddress("Волгоград");

        inputCompany("Sperasoft");

        inputCity("Volgograd");

        inputState();

        inputPostcode("66666");

        inputCountry();

        inputOther("Другое");

        inputPhone("666666");

        inputPhoneMobile("666666");

        inputAlias("Alias");

        register();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-heading")));
        String header = driver.findElement(By.cssSelector("h1.page-heading")).getText();
        // Verify that header equals "Selenium WebDriver"
        Assert.assertEquals(header, "MY ACCOUNT");
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
