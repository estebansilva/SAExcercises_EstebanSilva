package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartAddressPage extends BasePage{

    //Constructor
    public ShoppingCartAddressPage(WebDriver remoteDriver) {super(remoteDriver);}

    //FindBys
    @FindBy (css = "button[name=\"processAddress\"]")
    public WebElement proceedToCheckOutBtn;

    public ShoppingCartShippingPage ClickOnProceedToCheckOut(){

    //waiting for the address box to be displayed
        visibilityOfElementLocated(By.id("address_delivery"));
        waitToElementToBeClickable(proceedToCheckOutBtn);
    //going to the shipping section and agreeing to the terms

        proceedToCheckOutBtn.click();
        ShoppingCartShippingPage shoppingCartShippingPage = new ShoppingCartShippingPage(driver);
        return shoppingCartShippingPage;

    }
}
