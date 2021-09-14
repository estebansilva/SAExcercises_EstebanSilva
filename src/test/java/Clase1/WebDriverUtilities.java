package Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WebDriverUtilities {

    public static List<WebElement> searchElementsByClassnName (WebDriver driver, String nameClass){
        List<WebElement> listToReturn;

        listToReturn = driver.findElements(By.className(nameClass));

        if (listToReturn.isEmpty() == false){
            return listToReturn;
        }else {return null;}


    }
}
