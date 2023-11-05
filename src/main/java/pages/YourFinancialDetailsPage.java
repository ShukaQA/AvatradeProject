package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourFinancialDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int EXPLICIT_WAIT = 10;


    public YourFinancialDetailsPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    private final By registrationFrame = By.xpath("//iframe[@title='Iframe']");
    private final By primaryOccupationPath = By.xpath("//input[@data-automation='OccupationOrBusiness']");
    private final By currentlyEmployedPath = By.xpath("//input[@data-automation='EmploymentStatus']");
    private final By sourceOfTheFundsPath = By.xpath("//input[@data-automation='SourceOfTradeFunds']");
    private final By estimatedAnnualIncomePath = By.xpath("//input[@data-automation='EstimatedAnnualIncome']");
    private final By estimatedValuePath = By.xpath("//input[@data-automation='SavingsAndInvestments']");
    private final By investAmountPath = By.xpath("//input[@data-automation='AmountIntendInvestingEveryYear']");
    private final By submitButtonPath = By.xpath("//button[@type='submit']");

    public void setPrimaryOccupationDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(primaryOccupationPath));
        element.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void setCurrentlyEmployedDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(currentlyEmployedPath));
        element.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void setSourceOfTheFundsDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(sourceOfTheFundsPath));
        element.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void setEstimatedAnnualIncomeDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(estimatedAnnualIncomePath));
        element.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void setEstimatedValueDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(estimatedValuePath));
        element.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void setInvestAmountDropdown(String text) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(investAmountPath));
        element.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void clickSubmitButton() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonPath));
        element.click();
        driver.switchTo().defaultContent();
    }
}
