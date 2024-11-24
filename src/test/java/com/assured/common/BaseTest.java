package com.assured.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.assured.driver.DriverManager;
import com.assured.driver.TargetFactory;

public class BaseTest {

    // Initializes the WebDriver based on the browser passed as a parameter.
    @Parameters("BROWSER")
    @BeforeMethod
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize(); // Maximize window (optional)
    }

    // Cleans up the WebDriver after the test method execution.
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverManager.quit(); // Quits the WebDriver instance
    }

    // Method to create a browser driver and set it in DriverManager. This can be used in other classes to reuse the driver.
    public WebDriver createBrowser(@Optional("chrome") String browser) {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        driver.manage().window().maximize(); // Maximize window (optional)
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
    }
}
