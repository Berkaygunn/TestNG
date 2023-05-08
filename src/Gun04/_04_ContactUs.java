package Gun04;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContactUs extends BaseDriver {
    /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */

    @Test
    @Parameters("mesaj")
    void contactUs(String gelenMesaj){

        WebElement contactus=driver.findElement(By.xpath("//*[text()='Contact Us']"));
        contactus.click();

        WebElement text=driver.findElement(By.xpath("//*[@id='input-enquiry']"));
        text.sendKeys(gelenMesaj);

        WebElement submit=driver.findElement(By.xpath("//*[@type='submit']"));
        submit.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));

    }
}
