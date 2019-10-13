package com.bakulin.app;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        return new Object[][]{{
            User.newEntity()
                    .withFirstname("Firstname")
                    .withLastname("Lastname")
                    .withEmail("test_" + System.currentTimeMillis() +  "@test.test")
                    .withPassword("test_pass")
                    .withCompany("Sperasoft")
                    .withAddress("Volgograd")
                    .withAddresstwo("VLG")
                    .withCity("Volgograd")
                    .withPostcode("40012")
                    .withAdditional("info")
                    .withPhonehome("53329")
                    .withPhonemobile("666666")
                    .withAlias("alias")
                    .build()
        }};
    }
}
