package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int EXPLICIT_WAIT = 60;


    public AccountPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    private final By infoPopUpPath = By.xpath("//span[@data-key='updateTradingPopupTitle']");

    public String getPopUpTitleText() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(infoPopUpPath));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

}
