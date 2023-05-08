package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;

    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemleri(){
        System.out.println("başlangıç işlemleri");
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        loginTest();
    }

    void loginTest() {

        System.out.println(" logintest çalışıyor ");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement login = driver.findElement(By.xpath("(//a[text()='Login'])[2]"));
        login.click();

        WebElement email = driver.findElement(By.xpath("//*[@id='input-email']"));
        email.sendKeys("berkay@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id='input-password']"));
        password.sendKeys("berkay123");

        WebElement log = driver.findElement(By.xpath("//*[@value='Login']"));
        log.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
    }

    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(5);
        driver.quit();
    }

}
