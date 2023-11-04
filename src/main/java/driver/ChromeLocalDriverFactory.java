package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeLocalDriverFactory {

    private final ChromeOptions chromeOptions;

    ChromeLocalDriverFactory(ChromeOptions chromeOptions) {
        this.chromeOptions = chromeOptions;
    }

    WebDriver driver() {
        //TODO update driverManager (local version 119)
        //WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }


}
