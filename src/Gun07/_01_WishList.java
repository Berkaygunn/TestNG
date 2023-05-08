package Gun07;

import Gun06._03_PlaceHolderElements;
import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriver {
    /*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */

    @Test
    @Parameters("aranacakKelime")
    public void Test(String text){

        WebElement search=driver.findElement(By.cssSelector("[name='search']"));
        search.sendKeys("ipod");

        WebElement searchclick=driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg']"));
        searchclick.click();

        List<WebElement> searchResult=driver.findElements(By.cssSelector("div[class='caption']>h4>a"));
        int randomSecim= Tools.RandomGenerator(searchResult.size());
        String wishItemText=searchResult.get(randomSecim).getText();
        System.out.println("wishItemText = " + wishItemText);

        List<WebElement> wishBtnList=driver.findElements(By.cssSelector("[data-original-title='Add to Wish List']"));
        wishBtnList.get(randomSecim).click();

        WebElement wishclick=driver.findElement(By.id("wishlist-total"));
        wishclick.click();

        List<WebElement> wishTable=driver.findElements(By.cssSelector("[class='text-left']>a"));
        Tools.listContainsString(wishTable,wishItemText);

    }

}
