package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public abstract class BaseTest {

    private final WebDriver driver = new ChromeDriver();

    final String baseURL = "https://the-internet.herokuapp.com";

    @BeforeSuite
    protected void beforeMethod() {
        driver.get(baseURL);
    }

    @AfterSuite
    protected void afterMethod() {
        driver.quit();
    }

    private WebDriverWait wait5;

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }

        return wait5;
    }
}
