package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    // inheritence concept with Baseclass // base test method
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBorswer(baseUrl);
}

    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]")).click();
        String expectedMessage = "Computers";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals(expectedMessage,message.getText() );
    }

    @Test
     public void userShouldNavigateToElectronicsPageSuccessfully(){
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]")).click();
        String expectedMessage = "Electronics";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        Assert.assertEquals(expectedMessage,message.getText());
    }
     @Test

     public void userShouldNavigateToApparelPageSuccessfully (){
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]")).click();
        String expectedMessage = "Apparel";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        Assert.assertEquals(expectedMessage,message.getText());
     }
     @Test
     public void userShouldNavigateToDigitalDownloadsPageSuccessfull(){
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]")).click();
        String expectedMessage = "Digital downloads";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        Assert.assertEquals(expectedMessage,message.getText());
     }
      @Test
      public void userShouldNavigateToBooksPageSuccessfully(){
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]")).click();
        String expectedMessage = "Books";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        Assert.assertEquals(expectedMessage,message.getText());
      }
      @Test
      public void userShouldNavigateToJewelryPageSuccessfully(){
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]")).click();
        String expectedMessage = "Jewelry";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        Assert.assertEquals(expectedMessage,message.getText());
      }
      @Test
       public void userShouldNavigateToGiftCardsPageSuccessfully(){
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]")).click();
        String expectedMessage = "Gift Cards";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        Assert.assertEquals(expectedMessage,message.getText());
      }

      @After
    public void tearDown() {
        closeBroswer();

    }


}