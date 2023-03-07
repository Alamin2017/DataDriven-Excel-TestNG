package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_Data extends Base {

    public static WebDriver driver;

    @Test(dataProvider = "dataSupplier")
    public void testLogin(String email,String password,String result) throws InterruptedException {
        driver=openBrowser("Edge");
        driver.get("http://www.tutorialsninja.com/demo/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        if(result.contains("pass"))
        {
            Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        }
        else
        {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
            System.out.println("Need to valid data for login");
        }
        Thread.sleep(5000);
    }
    @DataProvider
    public Object[][] dataSupplier()
    {

        Object[][] data ={
                {"amotooricap9@gmail.com","12345","pass"},
                {"amotooricapvdf9@gmail.com","123453432","fail"},
                {"amotooricasgdp9@gmail.com","12345242","fail"}
        };
        return data;
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
