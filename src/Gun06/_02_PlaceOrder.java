package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_PlaceOrder extends BaseDriver {
    /*
         Senaryo :
         1- Siteyi açınız.
         2- Sitede "ipod" kelimesini aratınız
         3- Çıkan sonuçlardan ilkini sepete atınız.
         4- Shopping Chart a tıklatınız.
         5- Checkout yapınız.
         6- Continue butonalarına tıklatıp bilgileri giriniz.
         7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/


    @Test
    public void Test(){

        WebElement search=driver.findElement(By.cssSelector("[name='search']"));
        search.sendKeys("ipod");

        WebElement searchclick=driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg']"));
        searchclick.click();

        WebElement add= driver.findElement(By.xpath("//*[text()='Add to Cart']"));
        add.click();

        WebElement shoppigcart=driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
        shoppigcart.click();

        WebElement check1=driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[5]"));
        check1.click();

        WebElement continue1=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        continue1.click();

        WebElement continue2=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        continue2.click();

        WebElement continue3=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        continue3.click();


        WebElement box=driver.findElement(By.xpath("//*[@name='agree']"));
        box.click();

        WebElement continue4=wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        continue4.click();

        WebElement checkend=driver.findElement(By.xpath("//*[@value='Confirm Order']"));
        checkend.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement msg=driver.findElement(By.cssSelector("[id='content']>h1"));
        Assert.assertEquals(msg.getText(),"Your order has been placed!","Onay texti bulunamadı");



    }


}
