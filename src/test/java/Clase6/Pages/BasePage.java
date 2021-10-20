package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver remoteDriver){
        this.driver = remoteDriver;
        wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void waitVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTitleContains(String title) {wait.until(ExpectedConditions.titleContains(title));}

    public void waitToElementToBeClickable(WebElement element) {wait.until(ExpectedConditions.elementToBeClickable(element));}

    public void visibilityOfElementLocated (By locator) {wait.until(ExpectedConditions.visibilityOfElementLocated(locator));}

    public void waitTextToBePresentInElementLocated (By expectedLocator, String expectedText) {wait.until(ExpectedConditions.textToBePresentInElementLocated(expectedLocator, expectedText));}




}
