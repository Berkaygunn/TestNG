package Proje;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _04 extends BaseDriverParameter {
    //Test Case 4: Tab Menu Test
    //➢ Tab menudeki ürünlerin isimlerini liste atiniz
    //➢ Tab menu listesini locate ediniz
    //➢ Locate ettiginiz listenin elemanlarinin
    // tab menudeki ürünleri içerdiğini doğrulayınız.


    @Test(priority = 3)
    public void Test4(){
        driver.get("https://demo.nopcommerce.com/");

        List<WebElement> tabMenu=driver.findElements(By.xpath("//*[@class='top-menu notmobile']/li"));

        for (int i = 0; i < tabMenu.size(); i++) {
            if (tabMenu.get(i).getText().contains("computers"))
                Assert.assertTrue(tabMenu.get(i).equals("computers "));
            if (tabMenu.get(i).getText().contains("electronics"))
                Assert.assertTrue(tabMenu.get(i).equals("electronics "));
            if (tabMenu.get(i).getText().contains("apparel"))
                Assert.assertTrue(tabMenu.get(i).equals("apparel "));
            if (tabMenu.get(i).getText().contains("digital dowlands"))
                Assert.assertTrue(tabMenu.get(i).equals("digital dowlands "));
            if (tabMenu.get(i).getText().contains("books"))
                Assert.assertTrue(tabMenu.get(i).equals("books "));
            if (tabMenu.get(i).getText().contains("jewelry"))
                Assert.assertTrue(tabMenu.get(i).equals("jewelry "));
            if (tabMenu.get(i).getText().contains("gift cards"))
                Assert.assertTrue(tabMenu.get(i).equals("gift cards "));
        }
    }
}
