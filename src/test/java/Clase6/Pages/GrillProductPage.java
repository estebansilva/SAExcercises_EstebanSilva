package Clase6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GrillProductPage extends BasePage {

    //Constructor
    public GrillProductPage(WebDriver remoteDriver) {super(remoteDriver);}

    //Find Bys

    //this return a list of all the products that has been found
    @FindBy (css = "li.ajax_block_product")
    public List<WebElement> allTheProducts;




    public ProductPage selectTheFirstProduct() {

        //accesing and storing the link of the desired result, in this case the 0 corresponding to the Printed Summer Dress
        String productLink = allTheProducts.get(0).findElement(By.cssSelector("div.product-container a.product_img_link")).getAttribute("href");
        //going to the product page
        driver.get(productLink);
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }
}
