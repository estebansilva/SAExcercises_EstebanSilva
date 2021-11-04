package ExamenSeleniumAcademy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor

    public BasePage (WebDriver remoteDriver){
        this.driver = remoteDriver;
        //wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }
}
