package Proje;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02 extends BaseDriverParameter {

    ////➢ Login butonuna tıklayınız
    //    //➢ Kaydolduğunuz Email ve password giriniz
    //    //➢ LOG IN butonunna tıklayınız
    //    //➢ Başarılı bir şekilde login olduğunuzu doğrulayınız.


    @Test(priority = 1)
    public void Test2() {

        driver.get("https://demo.nopcommerce.com/");

        WebElement login = driver.findElement(By.xpath("//*[@class='ico-login']"));
        login.click();

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("berkayssss@gmail.com");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("berkayssss123");

        WebElement logbutton=driver.findElement(By.xpath("//button[text()='Log in']"));
        logbutton.click();

        WebElement check=driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(check.isDisplayed());



    }
}
