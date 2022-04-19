package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBroswer(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement singin = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        singin.click();

        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String expected = "Welcome Back!";

        Assert.assertEquals(expected, message.getText());
    }
    @Test
    public void verifyTheErrorMessage() {

        WebElement singInLink = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        singInLink.click();

        WebElement userName = driver.findElement(By.id("user[email]"));
        userName.sendKeys("sileniumtesting999@gmail.com");

        WebElement password = driver.findElement(By.id("user[password]"));
                password.sendKeys("bestofluck");

        WebElement loginButton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        loginButton.click();

       // password.sendKeys(Keys.ENTER);

        WebElement message = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/article/h1"));
        //List<WebElement> message = driver.findElements(By.className("message-text"));
         String expected = "Invalid email or password.";

         // assert message.get(0).getText().equals(expected);
    }
    @After
    public void tearDown() {
      //  closeBroser();
    }
}
