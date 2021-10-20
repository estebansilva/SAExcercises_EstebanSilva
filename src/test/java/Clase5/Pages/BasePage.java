package Clase5.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver remoteDriver){
        this.driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void waitVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
