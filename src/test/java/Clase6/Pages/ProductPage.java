package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{

    //Constructor
    public ProductPage(WebDriver remoteDriver) {super(remoteDriver);}

    //Find Bys
    @FindBy (css = "button[name=\"Submit\"]")
    public WebElement addToCartBtn;

    public ConfirmProductPage ClickOnAddToCartButton() {

        //waiting for the add to cart button to be clickable
       waitToElementToBeClickable(addToCartBtn);
       addToCartBtn.click();
       ConfirmProductPage confirmProductPage = new ConfirmProductPage(driver);
       return confirmProductPage;
    }
}
