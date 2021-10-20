package Clase6.Tests;

import Clase6.Pages.LandingPage;
import Clase6.Pages.MyAccountPage;
import Clase6.Pages.MenuPage;
import Clase6.Pages.GrillProductPage;
import Clase6.Pages.ProductPage;
import Clase6.Pages.*;
import Clase6.Constants.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingTest extends BaseTest {

    @Test
    public void buyingDressTest() throws InterruptedException {

        //logging in to the site
        LandingPage landingPage = new LandingPage(driver);
        landingPage.GoHomePage();

        RegisterAccountHelper registerAccountHelper = new RegisterAccountHelper(driver);
        MyAccountPage myAccountPage = registerAccountHelper.registerNewAccount();

        //search product via the search bar
        MenuPage menuPage = new MenuPage(driver);
        GrillProductPage grillProductPage = menuPage.searchAProduct(TextConstants.SEARCH_TEXT_PRODUCT);

        ProductPage productPage = grillProductPage.selectTheFirstProduct();
        ConfirmProductPage confirmProductPage = productPage.ClickOnAddToCartButton();

        ShoppingCartSummaryPage shoppingCartSummaryPage = confirmProductPage.clickOnProceedToCheckOutBtn();
        ShoppingCartAddressPage shoppingCartAddressPage = shoppingCartSummaryPage.ClickOnProceedToCheckOutBtn();
        ShoppingCartShippingPage shoppingCartShippingPage = shoppingCartAddressPage.ClickOnProceedToCheckOut();
        shoppingCartShippingPage.clickOnAgreeTermsOfServicesCheckBox();
        //going to the payment section
        ShoppingCartPaymentPage shoppingCartPaymentPage = shoppingCartShippingPage.clickOnProceedToCheckOutBtn();
        shoppingCartPaymentPage.clickOnPayByBankWire();
        shoppingCartPaymentPage.clickOnConfirmOrder();

        //assertions
        Assert.assertTrue(shoppingCartPaymentPage.getAllTheBoxText().contains(TextConstants.COMPLETE_ORDER_TITLE));
        Assert.assertTrue(shoppingCartPaymentPage.getAllTheBoxText().contains(TextConstants.COMPLETE_ORDER_PRICE));
        Assert.assertTrue(shoppingCartPaymentPage.getAllTheBoxText().contains(TextConstants.COMPLETE_ORDER_NAME_OWNER_ACCOUNT));
        Assert.assertTrue(shoppingCartPaymentPage.getAllTheBoxText().contains(TextConstants.COMPLETE_ORDER_DETAIL));
        Assert.assertTrue(shoppingCartPaymentPage.getAllTheBoxText().contains(TextConstants.COMPLETE_ORDER_BANK));
        Assert.assertTrue(shoppingCartPaymentPage.getAllTheBoxText().contains(TextConstants.COMPLETE_ORDER_SENDINGMSG));


    }


}
