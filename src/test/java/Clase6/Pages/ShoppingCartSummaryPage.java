package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartSummaryPage extends BasePage{

    //Constructor
    public ShoppingCartSummaryPage (WebDriver remoteDriver) {super(remoteDriver);}

    //FindBys
    @FindBy (css = "p a[title=\"Proceed to checkout\"]")
    public WebElement proceedToCheckOutBtn;

    public ShoppingCartAddressPage ClickOnProceedToCheckOutBtn() {


        //waiting to land the checkout page and checking if the cart has products because the div#order-detail-content only appears when products are in the cart
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order-detail-content")));
        visibilityOfElementLocated(By.id("order-detail-content"));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p a[title=’Proceed to checkout’]")));
        waitToElementToBeClickable(proceedToCheckOutBtn);
        //going to the address section
        proceedToCheckOutBtn.click();
        ShoppingCartAddressPage shoppingCartAddressPage = new ShoppingCartAddressPage(driver);
        return shoppingCartAddressPage;
    }
}
