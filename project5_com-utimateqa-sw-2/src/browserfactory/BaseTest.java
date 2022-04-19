package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBroswer(String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // Reference path of the driver.

        driver = new ChromeDriver();
        // Create a new driver Object

        driver.get(baseUrl);
        // Launch URl using the driver

        driver.manage().window().maximize();
        // maxmimise the browser

    }

    public void closeBroser() {
        driver.quit();
    }
}
