package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TermsAndConditionsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int EXPLICIT_WAIT = 30;


    public TermsAndConditionsPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    private final By registrationFrame = By.xpath("//iframe[@title='Iframe']");
    private final By termsAndConditionsRadioPath = By.xpath("//input[@name='TermsAndConditions']");

    public void setTermsAndConditionButtonTrue() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement radioButtonTerms =
                wait.until(ExpectedConditions.presenceOfElementLocated(termsAndConditionsRadioPath));
        radioButtonTerms.sendKeys("true");
        driver.switchTo().defaultContent();
    }
}
