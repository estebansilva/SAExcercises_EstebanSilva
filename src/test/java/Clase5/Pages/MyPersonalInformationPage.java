package Clase5.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPersonalInformationPage extends BasePage {

    //Constructor
    public MyPersonalInformationPage (WebDriver remoteDriver){
        super (remoteDriver);
    }

    //FindBys
    @FindBy(id = "firstname")
    public WebElement myPersonalInformationNameElement;

    @FindBy(id = "lastname")
    public WebElement myPersonalInformationLastNameElement;

    //Methods
    public String getActualFirstNameAccount(){

        return myPersonalInformationNameElement.getAttribute("value");
    }

    public String getActualLastNameAccount(){

        return myPersonalInformationLastNameElement.getAttribute("value");

    }
}
