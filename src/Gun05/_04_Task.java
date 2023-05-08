package Gun05;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _04_Task extends BaseDriver {
    /*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */

    @Test(dataProvider = "getData")
    void searchFunction(String text){

        WebElement search=driver.findElement(By.cssSelector("[name='search']"));
        search.clear();
        search.sendKeys(text);

        WebElement ara=driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        ara.click();

        List<WebElement> captions=driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for (WebElement e: captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(text));
    }

    @DataProvider
    Object[] getData()
    {
        Object[] data={"mac","ipod","samsung"};

        return data;
    }
}
