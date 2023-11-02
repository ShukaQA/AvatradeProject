package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    ChromeLocalDriverFactory chromeLocalDriverFactory;

    public DriverFactory() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptionsFactory().build();
        chromeLocalDriverFactory = new ChromeLocalDriverFactory(chromeOptions);
        chromeOptions.setHeadless(false);
    }

    public WebDriver createInstance(){
        return chromeLocalDriverFactory.driver();
    }
}
