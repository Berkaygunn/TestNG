package Gun05;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Task_2 extends BaseDriverParameter {
    /*
        * Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
        * sonrasında fakrlı tarayıcılar ile çalıştırınız. (crossbrowser)
        * sonrasında paralel çalıştırınız.(parallel)
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
