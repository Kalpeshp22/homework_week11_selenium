package testsuite;

import browserfactory.BaseTest;
import com.beust.ah.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.awt.windows.WEmbeddedFrame;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBroswer(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();

        WebElement actual = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String expected = "Secure Area";

        Assert.assertEquals(expected, actual.getText());
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();

        WebElement actual = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        String expected = "Your username is invalid!";

        Assert.assertEquals(expected, actual.getText());

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginButton = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]"));
        loginButton.click();

        WebElement actual = driver.findElement(By.xpath("//div[@id='flash']"));
        String expected = "Your password is invalid!";

        Assert.assertEquals(expected, actual.getText());
    }

    @After
    public void tearDown() {
        closeBroswer();
    }

}
