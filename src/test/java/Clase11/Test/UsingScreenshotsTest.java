package Clase11.Test;

import Clase11.Utilities.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners (value = TestListener.class)
public class UsingScreenshotsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(ITestContext context){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        context.setAttribute("WebDriver", driver);

    }

    @Test
    public void usingScreenshotTest(){
        driver.get("http://automationpractice.com/index.php");
        System.out.println(System.getProperty("user.dir"));

        Assert.assertTrue(false);

    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
