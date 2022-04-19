package testsuite;

import browserfactory.BaseTest;
import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.java2d.pipe.AAShapePipe;

public class RegisterTest extends BaseTest {
    // inheritence concept with Baseclass // base test method
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBorswer(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register", message.getText());

    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("kalpesh");
        driver.findElement(By.id("LastName")).sendKeys("panchal");

        driver.findElement(By.name("DateOfBirthDay")).sendKeys("6");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("October");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1987");

        driver.findElement(By.id("Email")).sendKeys("alpesh_panchal19936@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Krishnaa");

        driver.findElement(By.id("Password")).sendKeys("alpesh3210");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("alpesh3210");
        driver.findElement(By.id("register-button")).click();

        WebElement actual = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));

        Assert.assertEquals("Your registration completed", actual.getText());


    }
}
