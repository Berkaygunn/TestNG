package Proje;

import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _07 extends BaseDriverParameter {

    //➢ Search’e xml den aldiginiz “Adobe Photoshop CS4” giriniz
    //➢ Search butonuna tıklayınız
    //➢ Açılan sayfadaki urun baslığının bu text’I içerdiğini doğrulayınız

    @Test(priority = 6)
    @Parameters("photoshop")
    public void Test7(String text){
        driver.get("https://demo.nopcommerce.com/");

        WebElement searchbox=driver.findElement(By.id("small-searchterms"));
        searchbox.sendKeys(text);

        WebElement searchbutton=driver.findElement(By.cssSelector("button[type='submit']"));
        searchbutton.click();

        WebElement check=driver.findElement(By.xpath("//*[text()='Adobe Photoshop CS4']"));

        Assert.assertTrue(check.getText().contains("CS4"));


    }

}
