package com.bakulin.tests;

import org.testng.annotations.BeforeClass;
import com.bakulin.app.Application;

public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {app.quit(); app = null;}));
    }
}
