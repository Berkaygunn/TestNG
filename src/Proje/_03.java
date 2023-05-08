package Proje;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03 extends BaseDriverParameter {
    //➢ Login butonuna tıklayınız
    //➢ Geçerli ve geçersiz Email ve password’u Data Provider metodundan aliniz
    //➢ LOG IN butonunna tıklayınız
    //➢ başarılı bir şekilde login olup olmadığınızı doğrulayınız.


    @Test(priority = 2,dataProvider = "getdata")
    public void Test3(String mail, String pass){

        driver.get("https://demo.nopcommerce.com/");

        WebElement login = driver.findElement(By.xpath("//*[@class='ico-login']"));
        login.click();

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys(mail);

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys(pass);

        WebElement logins=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[2]")));
        logins.click();

       // driver.switchTo().alert().accept();

        WebElement check=driver.findElement(By.cssSelector("div[class='message-error validation-summary-errors']>:nth-child(1)>li"));
        Assert.assertTrue(check.getText().toLowerCase().contains("no customer"));


    }
    @DataProvider
    public Object[] getdata(){

        Object[][] gecersizIdPass={{"ber@gmail.com","1234bess"}};

        return gecersizIdPass;
    }


}
