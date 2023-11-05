package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourFinancialDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public YourFinancialDetailsPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    private final By dropDownPath = By.xpath("//input[@name='EmploymentStatus']");

    public void clickDropDown() {
        driver.findElement(dropDownPath).sendKeys("1");
    }
}
