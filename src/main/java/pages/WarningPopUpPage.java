package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WarningPopUpPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int EXPLICIT_WAIT = 10;


    public WarningPopUpPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    private final By registrationFrame = By.xpath("//iframe[@title='Iframe']");
    private final By agreeButtonPath = By.xpath("//span[@id]");

    public void clickAgreeButton() {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(agreeButtonPath));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        driver.switchTo().defaultContent();
    }
}
