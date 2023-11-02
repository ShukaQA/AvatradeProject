package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

import static util.RobotExample.typeText;

public class UserRegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserRegistrationPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    private final By registrationFrame = By.xpath("//iframe[@title='Iframe']");
    private final By firstNameInputPath = By.name("FirstName");
    private final By lastNameInputPath = By.xpath("//input[@name='LastName']");
    private final By dateOfBirthPath = By.xpath("//input[@name='date-of-birth-day']");
    private final By countryInputPath = By.xpath("//input[@name='Country']");
    private final By cityInputPath = By.xpath("//input[@name='City']");
    private final By streetInputPath = By.xpath("//input[@name='Street']");
    private final By streetNumberInputPath = By.xpath("//input[@name='BuildingNumber']");
    private final By flatInputPath = By.xpath("//input[@name='Flat']");

    private final By loadingOverlayPath = By.xpath("//div[@class='v-overlay v-overlay--absolute v-overlay--active theme--dark']");


    public void setFirstNameInput(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(registrationFrame));
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(firstNameInputPath));
        nameInput.click();
        try {
            typeText(new Robot(), name);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
    }

    public void setLastNameInput(String name) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(lastNameInputPath));
        nameInput.sendKeys(name);
        driver.switchTo().defaultContent();
    }

    public void setDateOfBirthInput(String date) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement dateInput = wait.until(ExpectedConditions.presenceOfElementLocated(dateOfBirthPath));
        dateInput.click();
        try {
            typeText(new Robot(), date);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
    }

    public void setCountryInput(String country) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        wait.until(ExpectedConditions.presenceOfElementLocated(countryInputPath));
        List<WebElement> countryInputs = driver.findElements(countryInputPath);
        countryInputs.get(0).sendKeys(country);
        countryInputs.get(0).sendKeys(Keys.TAB);
        driver.switchTo().defaultContent();
    }

    public void setCityInput(String city) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        waitForLoaderDisappear();
        WebElement nameInput = wait.until(ExpectedConditions.presenceOfElementLocated(cityInputPath));
        wait.until(ExpectedConditions.elementToBeClickable(cityInputPath));
        nameInput.sendKeys(Keys.PAGE_DOWN);
        nameInput.sendKeys(city);
        driver.switchTo().defaultContent();
    }

    private void waitForLoaderDisappear() {
        WebElement loader = driver.findElement(loadingOverlayPath);
        wait.until(ExpectedConditions.visibilityOf(loader));
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }

    public void setStreetInput(String street) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(streetInputPath));
        nameInput.click();
        nameInput.sendKeys(street);
        driver.switchTo().defaultContent();
    }

    public void setStreetNumberInput(String number) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(streetNumberInputPath));
        nameInput.click();
        nameInput.sendKeys(number);
        driver.switchTo().defaultContent();
    }

    public void setFlatInput(String flat) {
        driver.switchTo().frame(driver.findElement(registrationFrame));
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(flatInputPath));
        nameInput.click();
        nameInput.sendKeys(flat);
        driver.switchTo().defaultContent();
    }

}
