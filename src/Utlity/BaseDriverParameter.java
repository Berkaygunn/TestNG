package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public  WebDriver driver; // her classın kendi driverı olsun.

    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemleri(String browserTipi)
    {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browserTipi.equalsIgnoreCase("firefox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver =new FirefoxDriver();
        }
        else if (browserTipi.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        }
        else
        {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        //loginTest();
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
