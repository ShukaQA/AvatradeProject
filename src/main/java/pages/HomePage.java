package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(driver, this);
    }

    private final By registerButtonPath = By.xpath("//a[@class='btn btn-orange animate-btn']");

    public void clickRegisterButton() {
        driver.navigate().refresh();
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerButtonPath));
        registerButton.click();

         /*
        WebElement registerBut = wait.until(ExpectedConditions.elementToBeClickable(registerButtonPath));
        try {
            wait.until(ExpectedConditions.textToBe(registerButtonPath, "Create my account"));
        } catch (Exception e) {
            wait.until(ExpectedConditions.textToBe(registerButtonPath, "Open trading account"));
        }*/

        //WebElement registerButton = driver.findElement(registerButtonPath);
    }

}
