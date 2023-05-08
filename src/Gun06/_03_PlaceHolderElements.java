package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_PlaceHolderElements {

    public _03_PlaceHolderElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css= "[name='search']")
    public WebElement search;

    @FindBy(xpath = "//*[@class='btn btn-default btn-lg']")
    public WebElement searchclick;

    @FindBy(xpath = "//*[text()='Add to Cart']")
    public WebElement add;

    @FindBy(xpath = "//*[text()='Shopping Cart']")
    public WebElement shoppigcart;

    @FindBy(xpath = "(//*[@class='btn btn-primary'])[5]")
    public WebElement check1;

    @FindBy(xpath = "//*[@value='Confirm Order']")
    public WebElement checkend;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;

    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(xpath = "//*[@name='agree']")
    public WebElement box;

    @FindBy(css = "[id='content']>h1")
    public WebElement msg;





}
