package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TradingExperiencePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int EXPLICIT_WAIT = 10;


    public TradingExperiencePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    private final By registrationFrame = By.xpath("//iframe[@title='Iframe']");
    private final By yesButtonPath = By.xpath("//span[@id]");
    private final By tradingExperienceForexPath = By.xpath("//input[@data-automation='NumOfTimesTradedinForexCfds']");
    private final By averageTradeSizePath = By.xpath("//input[@data-automation='WhatWasTheAverageSizeOfTrades']");

    private final By tradingWithLeveragePath = By.xpath("//input[@data-automation='TradingWithLeverageApplies']");
    private final By tradingWithLeverageMaximumPath = By.xpath("//input[@data-automation='TradingWithLeverageMaximumPosition']");
    private final By openPositionPath = By.xpath("//input[@data-automation='OpenPositionAutomaticallyClose']");
    private final By tradeWithUsPath = By.xpath("//input[@data-automation='WhyTradeWithUs']");
    private final By checkBoxPath = By.xpath("//div[@class='form-item checkbox']");
    private final By submitButtonPath = By.xpath("//button[@type='submit']");


    public void clickYesButton() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        wait.until(ExpectedConditions.presenceOfElementLocated(yesButtonPath));
        WebElement element = driver.findElements(yesButtonPath).get(0);
        element.click();
        driver.switchTo().defaultContent();
    }

    public void setTradingExperienceForexDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(tradingExperienceForexPath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void setAverageTradeSizeDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(averageTradeSizePath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void setTradingWithLeverageDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(tradingWithLeveragePath));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void setTradingWithLeverageMaximumDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(tradingWithLeverageMaximumPath));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void setOpenPositionDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(openPositionPath));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void setTradeWithUsDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(tradeWithUsPath));
        element.sendKeys(Keys.PAGE_DOWN);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void clickCheckBoxButton() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(checkBoxPath));
        element.click();
        driver.switchTo().defaultContent();
    }

    public void clickSubmitButton() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonPath));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        driver.switchTo().defaultContent();
    }
}
