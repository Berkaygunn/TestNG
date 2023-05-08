package Gun06;

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrder extends BaseDriver {


    @Test
    public void test(){

        _03_PlaceHolderElements elements=new _03_PlaceHolderElements();


        elements.search.sendKeys("ipod");
        elements.searchclick.click();
        elements.add.click();
        elements.shoppigcart.click();
        elements.check1.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
        elements.box.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.checkend.click();

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.msg.getText(),"Your order has been placed!","Onay texti bulunamadı");
    }
}
