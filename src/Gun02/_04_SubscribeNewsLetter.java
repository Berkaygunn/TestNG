package Gun02;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_SubscribeNewsLetter extends BaseDriver {
    /*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)
  3- 3- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
  4- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.
 */

    @Test
    void Test(){


        WebElement news=driver.findElement(By.xpath("//a[text()='Newsletter']"));
        news.click();

        WebElement yes=driver.findElement(By.xpath("//*[@name='newsletter']"));
        yes.click();

        WebElement cont=driver.findElement(By.xpath("//*[@value='Continue']"));
        cont.click();

        WebElement subs=driver.findElement(By.xpath("//*[text()=' Success: Your newsletter subscription has been successfully updated!']"));

        Assert.assertTrue(subs.getText().contains("Success:"));
    }

    @Test
    void subscribeFunctionNo(){

        WebElement news=driver.findElement(By.xpath("//a[text()='Newsletter']"));
        news.click();

        WebElement yes=driver.findElement(By.xpath("//input[@value='0']"));
        yes.click();

        WebElement cont=driver.findElement(By.xpath("//*[@value='Continue']"));
        cont.click();

        WebElement subs=driver.findElement(By.xpath("//*[text()=' Success: Your newsletter subscription has been successfully updated!']"));

        Assert.assertTrue(subs.getText().contains("Success:"));

    }

    @Test
    void subscribeFunctionForBoth(){

        WebElement news=driver.findElement(By.xpath("//a[text()='Newsletter']"));
        news.click();

        WebElement yes=driver.findElement(By.xpath("//input[@value='1']"));
        yes.click();





    }
}
