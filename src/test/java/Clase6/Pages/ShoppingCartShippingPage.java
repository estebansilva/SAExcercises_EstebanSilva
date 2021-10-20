package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartShippingPage extends BasePage{

    //Constructor
    public ShoppingCartShippingPage (WebDriver remoteDriver) {super(remoteDriver);}

    //FindBys
    @FindBy (id = "cgv")
    public WebElement termsOfServicesCheckBox;

    @FindBy (css = "button[name=\"processCarrier\"]")
    public WebElement proceedToCheckOutBtn;

    public void clickOnAgreeTermsOfServicesCheckBox() {

        visibilityOfElementLocated(By.className("order_carrier_content"));
        termsOfServicesCheckBox.click();
    }

    public ShoppingCartPaymentPage clickOnProceedToCheckOutBtn(){

        proceedToCheckOutBtn.click();
        ShoppingCartPaymentPage shoppingCartPaymentPage = new ShoppingCartPaymentPage(driver);
        return shoppingCartPaymentPage;
    }
}
