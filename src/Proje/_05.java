package Proje;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _05 extends BaseDriverParameter {

    //➢ Tab menuden gifts’e tıklayınız
    //➢ Physical giftlerden birini random olarak seciniz
    //➢ Açılan sayfada recipient name, sender name ve message bölümlerini doldurunuz
    //➢ Ad To Cart’a tıklayınız
    //➢ Urunun sepete eklendiğini doğrulayınız

    @Test(priority = 4)
    public void Test5(){

        driver.get("https://demo.nopcommerce.com/");

        WebElement giftCards=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Gift Cards ']")));
        giftCards.click();


        List<WebElement> gift=driver.findElements(By.xpath("//*[@class='product-title']/a"));
        int rndsayi=(int)(Math.random()*gift.size());

        gift.get(rndsayi).click();

        driver.getCurrentUrl();
        if (driver.getCurrentUrl().contains("25-")){
            WebElement recipent=driver.findElement(By.xpath("//*[@class='recipient-name']"));
            recipent.sendKeys("ismet hoca");

            WebElement senders=driver.findElement(By.xpath("//input[@class='sender-name']"));
            senders.sendKeys("Group 14");

            WebElement message=driver.findElement(By.xpath("//textarea[@class='message']"));
            message.sendKeys("Doğum günün kutlu olsun");

            WebElement repmail=driver.findElement(By.xpath("//*[@class='recipient-email']"));
            repmail.clear();
            repmail.sendKeys("repicient14@gmail.com");

            WebElement sendermail=driver.findElement(By.xpath("//*[@class='sender-email']"));
            sendermail.clear();
            sendermail.sendKeys("senders14@gmail.com");

            WebElement add=driver.findElement(By.xpath("//*[text()='Add to cart']"));
            add.click();
        }

        else {
            WebElement recipent=driver.findElement(By.xpath("//*[@class='recipient-name']"));
            recipent.sendKeys("ismet hoca");

            WebElement senders=driver.findElement(By.xpath("//input[@class='sender-name']"));
            senders.sendKeys("Group 14");

            WebElement message=driver.findElement(By.xpath("//textarea[@class='message']"));
            message.sendKeys("Doğum günün kutlu olsun");

            WebElement add=driver.findElement(By.xpath("//*[text()='Add to cart']"));
            add.click();

        }

        WebElement notifications=driver.findElement(By.xpath("//*[text()='The product has been added to your ']"));

        Assert.assertTrue(notifications.getText().contains("The product has "));





    }
}
