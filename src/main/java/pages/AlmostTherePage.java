package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlmostTherePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int EXPLICIT_WAIT = 60;


    public AlmostTherePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    private final By verifyButtonPath = By.xpath("//div[@class='action-button']");

    public void clickVerifyButton() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(verifyButtonPath));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

}
