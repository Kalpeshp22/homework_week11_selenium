package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    // inheritence concept with Baseclass // base test method
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBorswer(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToLogininPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        loginLink.click();

        String expectedMessage = "Welcome, Please Sign In!";
        // find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        // Relative Xpath
        String actualMessage = actualMessageElement.getText();

        //validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
       /*
       ? When using assert, the condition that you pass should be true
       ? If false, you will receive an error
       * */
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        loginLink.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("prime@testing.com");

        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("pas123");

        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String expected = "Log out";

        Assert.assertEquals(expected, logoutLink.getText());
    }
    @Test
    public void verifyTheErrorMessage() {

        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        loginLink.click();

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("testing@pr.com");

        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("Error");

        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        String expected = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
        String actualValue = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]")).getText();

//        Assert.assertEquals(expected, actualValue);
        System.out.println(actualValue);

    }
    @After
    public void tearDown() {
        closeBroswer();
    }
}
