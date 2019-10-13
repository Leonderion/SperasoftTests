package com.bakulin.tests;

import com.bakulin.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test (dataProvider = "data-provider", dataProviderClass = DataProviders.class) // Marking this method as part of the test
    public void createAnAccount(User user) throws InterruptedException {

        app.registerNewUser(user);
        //Переход на главную страницу

        Assert.assertEquals(app.getHeader(), "MY ACCOUNT");
        //Thread.sleep(10000);
    }
}
