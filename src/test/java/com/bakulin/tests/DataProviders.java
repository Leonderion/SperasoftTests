package com.bakulin.tests;

import com.bakulin.model.User;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        return new Object[][]{
                {User.newEntity()
                        .withGender("Mr")
                        .withFirstname("Firstname")
                        .withLastname("Lastname")
                        .withEmail("test_" + System.currentTimeMillis() + "@test.test")
                        .withPassword("test_pass")
                        .withDayOfBirth("10")
                        .withMouthOfBirth("5")
                        .withYearOfBirth("2000")
                        .withCompany("Sperasoft")
                        .withAddress("Volgograd")
                        .withAddresstwo("VLG")
                        .withCity("Volgograd")
                        .withState("2")
                        .withPostcode("40012")
                        .withCountry("21")
                        .withAdditional("info")
                        .withPhonehome("53329")
                        .withPhonemobile("666666")
                        .withAlias("alias")
                        .build()
                }
        };
    }
}
