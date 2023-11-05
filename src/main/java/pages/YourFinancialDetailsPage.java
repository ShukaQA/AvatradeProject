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

    public void clickPrimaryOccupationDropdownClickFirst() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(primaryOccupationPath));
        element.sendKeys("Accountancy");
        driver.switchTo().defaultContent();
    }

    public void currentlyEmployedDropdownClickFirst() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(currentlyEmployedPath));
        element.sendKeys("1");
        driver.switchTo().defaultContent();
    }
}
