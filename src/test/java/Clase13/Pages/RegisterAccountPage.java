package Clase13.Pages;

import Clase13.Clases.Persona;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterAccountPage {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public RegisterAccountPage(WebDriver remoteDriver){
        this.driver = remoteDriver;
        wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //FindBys
    @FindBy (id = "0_signup_email")
    public WebElement emailAddress;
    @FindBy (id = "0_signup_shop_name")
    public WebElement storeName;

    public void registerAccount(List<Persona> listaPersonas, int contador) {
        //System.out.println(listaPersonas.get(contador));
        Persona pers = listaPersonas.get(contador);
        //System.out.println(listaPersonas.get(contador).toString());
        emailAddress.sendKeys(pers.getLoginEmail());
        storeName.sendKeys(pers.getFirstName() + " " + pers.getLastName());

    }
}
