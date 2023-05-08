package Proje;

import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Senaryolar extends BaseDriverParameter {

    @Test(priority = 1)
    public void Test1() {

        driver.get("https://demo.nopcommerce.com/");

        WebElement login = driver.findElement(By.xpath("//*[@class='ico-login']"));
        login.click();

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("berkayssss@gmail.com");

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("berkayssss123");

        WebElement logbutton=driver.findElement(By.xpath("//button[text()='Log in']"));
        logbutton.click();

        WebElement check=driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(check.isDisplayed());

    }

    @Test(priority = 2,dataProvider = "getdata")
    public void Test2(String mail, String pass){

        driver.get("https://demo.nopcommerce.com/");

        WebElement login = driver.findElement(By.xpath("//*[@class='ico-login']"));
        login.click();

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys(mail);

        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys(pass);

        WebElement check=driver.findElement(By.xpath("//*[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        Assert.assertTrue(check.getText().contains("Login was unsuccess"));

    }
    @DataProvider
    public Object[] getdata(){

        Object[] gecersizIdPass={"ber@gmail.com","1234bess"};

        return gecersizIdPass;
    }

    @Test(priority = 3)
    public void Test3(){
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

    @Test(priority = 4)
    public void Test4(){

        driver.get("https://demo.nopcommerce.com/");

        WebElement giftCards=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Gift Cards ']")));
        giftCards.click();


        List<WebElement> gift=driver.findElements(By.xpath("//*[@class='product-title']/a"));
        int rndsayi=(int)(Math.random()*gift.size());
        gift.get(rndsayi).click();

        driver.getCurrentUrl();

        if (driver.getCurrentUrl().contains("25-")){
            WebElement recipent=driver.findElement(By.xpath("//*[@class='recipient-name']"));
            recipent.sendKeys("ismet hoca");

            WebElement senders=driver.findElement(By.xpath("//input[@class='sender-name']"));
            senders.sendKeys("Group 14");

            WebElement message=driver.findElement(By.xpath("//textarea[@class='message']"));
            message.sendKeys("Doğum günün kutlu olsun");

            WebElement repmail=driver.findElement(By.xpath("//*[@class='recipient-email']"));
            repmail.clear();
            repmail.sendKeys("repicient14@gmail.com");

            WebElement sendermail=driver.findElement(By.xpath("//*[@class='sender-email']"));
            sendermail.clear();
            sendermail.sendKeys("senders14@gmail.com");

            WebElement add=driver.findElement(By.xpath("//*[text()='Add to cart']"));
            add.click();
        }

        else {
            WebElement recipent=driver.findElement(By.xpath("//*[@class='recipient-name']"));
            recipent.sendKeys("ismet hoca");

            WebElement senders=driver.findElement(By.xpath("//input[@class='sender-name']"));
            senders.sendKeys("Group 14");

            WebElement message=driver.findElement(By.xpath("//textarea[@class='message']"));
            message.sendKeys("Doğum günün kutlu olsun");

            WebElement add=driver.findElement(By.xpath("//*[text()='Add to cart']"));
            add.click();

        }

        WebElement notifications=driver.findElement(By.xpath("//*[text()='The product has been added to your ']"));

        Assert.assertTrue(notifications.getText().contains("The product has "));

    }

    @Test(priority = 5)
    public void Test5(){

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
        select.selectByIndex(rndsayi);

        List<WebElement> hdd=driver.findElements(By.xpath("//*[@data-attr='3']/li/input"));
        int hddrandom=(int)(Math.random()*hdd.size());
        hdd.get(hddrandom).click();

        WebElement add=driver.findElement(By.xpath("//*[text()='Add to cart']"));
        add.click();

        WebElement checkadd=driver.findElement(By.xpath("//*[text()='The product has been added to your ']"));
        Assert.assertTrue(checkadd.getText().contains("added to "));

    }

    @Test(priority = 6)
    @Parameters("photoshop")
    public void Test6(String text){
        driver.get("https://demo.nopcommerce.com/");

        WebElement searchbox=driver.findElement(By.id("small-searchterms"));
        searchbox.sendKeys(text);

        WebElement searchbutton=driver.findElement(By.cssSelector("button[type='submit']"));
        searchbutton.click();

        WebElement check=driver.findElement(By.xpath("//*[text()='Adobe Photoshop CS4']"));

        Assert.assertTrue(check.getText().contains("CS4"));


    }


}
