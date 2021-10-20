package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmProductPage extends BasePage {

    //Constructor
    public ConfirmProductPage (WebDriver remoteDriver) {super(remoteDriver);}

    //FindBys
    @FindBy (css = "a[title=\"Proceed to checkout\"]")
    public WebElement proceedToCheckOutBtn;

    @FindBy (id = "layer_cart")
    public WebElement layerCartElement;

    public ShoppingCartSummaryPage clickOnProceedToCheckOutBtn() {


        //waiting for the modal to open and then clicking on Proceed to checkout
        visibilityOfElementLocated(By.id("layer_cart"));
        proceedToCheckOutBtn.click();
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        return shoppingCartSummaryPage;
    }
}
