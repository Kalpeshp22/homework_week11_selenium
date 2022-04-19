package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBorswer(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement actual = driver.findElement(By.id("welcome"));
        String expected = "Welcome";

        assert actual.getText().contains(expected);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

