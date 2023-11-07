package util;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static util.PropertyLoader.returnConfigValue;

public abstract class BaseTest {

    protected static WebDriver driver;

    protected HomePage homePage;
    protected RegistrationPopUpPage registrationPopUpPage;
    protected YourPersonalDetailsPage yourPersonalDetailsPage;
    protected YourFinancialDetailsPage yourFinancialDetailsPage;
    protected TradingExperiencePage tradingExperiencePage;
    protected TermsAndConditionsPage termsAndConditionsPage;
    protected WarningPopUpPage warningPopUpPage;
    protected AlmostTherePage almostTherePage;
    protected AccountPage accountPage;

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
        yourPersonalDetailsPage = new YourPersonalDetailsPage(driver);
        yourFinancialDetailsPage = new YourFinancialDetailsPage(driver);
        tradingExperiencePage = new TradingExperiencePage(driver);
        termsAndConditionsPage = new TermsAndConditionsPage(driver);
        warningPopUpPage = new WarningPopUpPage(driver);
        almostTherePage = new AlmostTherePage(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterMethod
    public void postCondition() {
        driver.quit();
    }
}