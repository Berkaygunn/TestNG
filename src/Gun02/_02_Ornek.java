package Gun02;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {


    @Test
    void loginTest(){

        System.out.println(" logintest çalışıyor ");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement login=driver.findElement(By.xpath("(//a[text()='Login'])[2]"));
        login.click();

        WebElement email=driver.findElement(By.xpath("//*[@id='input-email']"));
        email.sendKeys("berkay@gmail.com");

        WebElement password=driver.findElement(By.xpath("//*[@id='input-password']"));
        password.sendKeys("berkay123");

        WebElement log=driver.findElement(By.xpath("//*[@value='Login']"));
        log.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));




    }
}
