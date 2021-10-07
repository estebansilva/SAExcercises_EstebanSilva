package Clase5.Pages;

import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver remoteDriver){
        super(remoteDriver);
    }


    public void GoHomePage() {
        driver.navigate().to("http://automationpractice.com/index.php");
    }
}
