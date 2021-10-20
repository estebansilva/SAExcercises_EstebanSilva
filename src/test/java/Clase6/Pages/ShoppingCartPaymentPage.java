package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class ShoppingCartPaymentPage extends BasePage{

    //Constructor
    public ShoppingCartPaymentPage (WebDriver remoteDriver) {super(remoteDriver);}

    //FindBys
    @FindBy (id = "HOOK_PAYMENT")
    public WebElement hookpayment;

    @FindBy (className = "bankwire")
    public WebElement payByBankWireBtn;

    @FindBy (css = "#cart_navigation button")
    public WebElement confirmOrderBtn;

    @FindBy (className = "box")
    public WebElement buyDetailsBox;



    public void clickOnPayByBankWire() {
        //checking if the payment methods are present, this is easy, just check if the div container is being displayed
        visibilityOfElementLocated(By.id("HOOK_PAYMENT"));
        //selecting the bankwire option
        waitToElementToBeClickable(payByBankWireBtn);
        payByBankWireBtn.click();
        //checking if we selected the payment method correctly
        System.out.println(driver.findElement(By.className("page-subheading")).getText());
        waitTextToBePresentInElementLocated(By.className("page-subheading"), "BANK-WIRE PAYMENT.");

    }

    public void clickOnConfirmOrder() {
        //confirming order by clicking on the Confirm Order button
        confirmOrderBtn.click();
        visibilityOfElementLocated(By.className("cheque-indent"));
     }

    public String getAllTheBoxText() {
        return buyDetailsBox.getText();
    }
}
