package com.bakulin.tests;

import com.bakulin.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test (dataProvider = "data-provider", dataProviderClass = DataProviders.class, testName = "AllField")
    public void createAnAccountAllField(User user) throws InterruptedException {

        app.registerNewUserAllField(user);

        Assert.assertEquals(app.getHeaderAfterLogon(), "MY ACCOUNT");
    }

    @Test (dataProvider = "data-provider", dataProviderClass = DataProviders.class, testName = "RequiredField")
    public void createAnAccountRequiredFieldsOnly(User user) throws InterruptedException {

        app.registerNewUserAllFieldRequiredFieldsOnly(user);

        Assert.assertEquals(app.getHeaderAfterLogon(), "MY ACCOUNT");
    }
}
