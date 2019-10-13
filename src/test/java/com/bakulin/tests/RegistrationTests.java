package com.bakulin.tests;

import com.bakulin.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test (dataProvider = "data-provider", dataProviderClass = DataProviders.class)
    public void createAnAccount(User user) throws InterruptedException {

        app.registerNewUser(user);

        Assert.assertEquals(app.getHeaderAfterLogon(), "MY ACCOUNT");
    }
}
