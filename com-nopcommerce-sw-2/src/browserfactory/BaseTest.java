package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

 public static WebDriver driver;

  public void openBorswer(String baseUrl){
   System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
   driver = new ChromeDriver();
   // Lunch The URl.
   driver.get(baseUrl);
   // Maximise Window
    driver.manage().window().maximize();
   // We Giveimplicit time to driver
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

  }
   public void closeBroswer(){
     driver.quit();
   }
}
