package Proje;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//➢ Tab menudeki Computers üzerine gidiniz
//➢ Drop down dan Desktops’a tıklayınız
//➢ Açılan sayfadan Build your own computer’i seciniz
//➢ Random bir RAM seciniz
//➢ Random bir HDD seciniz
//➢ AD TO CART’a tıklayınız
//➢ Urunun başarılı bir şekilde sepete eklendiğini doğrulayınız

public class _06 extends BaseDriverParameter {

    @Test(priority = 5)
    public void Test6(){

        driver.get("https://demo.nopcommerce.com/");

        Actions actions=new Actions(driver);

        WebElement computers=driver.findElement(By.xpath("//*[text()='Computers ']"));
        actions.moveToElement(computers).build().perform();

        WebElement desktop=driver.findElement(By.xpath("//*[text()='Desktops ']"));
        desktop.click();

        WebElement kasa=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Build your own computer")));
        kasa.click();

        WebElement ramMenu=wait.until(ExpectedConditions.elementToBeClickable(By.id("product_attribute_2")));
        List<WebElement> ramlist=driver.findElements(By.xpath("//select[@id='product_attribute_2']/option"));

        Select select=new Select(ramMenu);

        int rndsayi=(int)(Math.random()*ramlist.size());
        actions.scrollToElement(ramMenu);
        select.selectByIndex(rndsayi);

        List<WebElement> hdd=driver.findElements(By.xpath("//*[@data-attr='3']/li/input"));
        int hddrandom=(int)(Math.random()*hdd.size());
        hdd.get(hddrandom).click();

        WebElement add=driver.findElement(By.xpath("//*[text()='Add to cart']"));
        add.click();

        WebElement checkadd=driver.findElement(By.xpath("//*[text()='The product has been added to your ']"));
        Assert.assertTrue(checkadd.getText().contains("added to "));


    }
}
