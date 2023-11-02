package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPopUpPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegistrationPopUpPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    private final By mailInputPath = By.id("input-email");
    private final By passwordInputPath = By.id("input-password");
    private final By submitButtonPath = By.xpath("//button[contains(@id, 'btn_ga_real_main')]");

    public void setMailInput(String mail) {
        WebElement mailInput = wait.until(ExpectedConditions.presenceOfElementLocated(mailInputPath));
        mailInput.sendKeys(mail);
    }

    public void setPasswordInput(String mail) {
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(passwordInputPath));
        passwordInput.sendKeys(mail);
    }

    public void clickSubmitButton() {
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonPath));
        passwordInput.click();
    }


}
