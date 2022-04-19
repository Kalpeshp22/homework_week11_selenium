package testsuite;

import browserfactory.BaseTest;
import com.beust.ah.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBorswer(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotPassword.click();

       // WebElement forgotPasswrod = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
       // forgotPassword.click();

        WebElement actual = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String expected = "Forgot Your Password?";

        Assert.assertEquals(expected,actual.getText());



    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}



