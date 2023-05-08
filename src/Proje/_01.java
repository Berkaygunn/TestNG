package Proje;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01 extends BaseDriver {

    //➢ https://demo.nopcommerce.com/register?returnUrl=%2F Sitesine gidiniz
    //➢ Register butonuna tıklayınız
    //➢ First Name ve Last Name giriniz
    //➢ Doğum tarihi kısımlarını select ile seciniz
    //➢ Email giriniz
    //➢ Password ve password confirm giriniz
    //➢ Register butonuna tıklayınız
    //➢ Başarılı bir şekilde kaydolduğunuzu doğrulayınız.


   // @Test
    public void Test(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys("berkay");


        WebElement lastName=driver.findElement(By.id("LastName"));
        lastName.sendKeys("gün");


        WebElement dateDay=driver.findElement(By.cssSelector("[name='DateOfBirthDay']"));
        Select select1=new Select(dateDay);
        select1.selectByValue("11");

        WebElement dateMonth=driver.findElement(By.cssSelector("[name='DateOfBirthMonth']"));
        Select select2=new Select(dateMonth);
        select2.selectByVisibleText("July");

        WebElement dateYear=driver.findElement(By.cssSelector("[name='DateOfBirthYear']"));
        Select select3=new Select(dateYear);
        select3.selectByVisibleText("1999");

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("berkayssss@gmail.com");

        WebElement company=driver.findElement(By.id("Company"));
        company.sendKeys("technostudy");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("berkayssss123");

        WebElement trypass=driver.findElement(By.id("ConfirmPassword"));
        trypass.sendKeys("berkaysss123");

        WebElement gender=driver.findElement(By.id("gender-male"));
        gender.click();

        WebElement register=driver.findElement(By.id("register-button"));
        register.click();

        WebElement text=driver.findElement(By.xpath("//*[text()='Your registration completed']"));
        Assert.assertTrue(text.getText().equals("Your registration completed"));

    }



}
