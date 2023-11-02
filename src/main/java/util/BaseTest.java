package util;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.RegistrationPopUpPage;
import pages.UserRegistrationPage;

import static util.PropertyLoader.returnConfigValue;

public abstract class BaseTest {

    protected static WebDriver driver;

    protected HomePage homePage;
    protected RegistrationPopUpPage registrationPopUpPage;

    protected UserRegistrationPage userRegistrationPage;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void preCondition() {
        driver = new DriverFactory().createInstance();
        driver.manage().window().maximize();
        driver.get(returnConfigValue("url.base"));
        homePage = new HomePage(driver);
        registrationPopUpPage = new RegistrationPopUpPage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
    }

    @AfterMethod
    public void postCondition() {
        driver.quit();
    }
}