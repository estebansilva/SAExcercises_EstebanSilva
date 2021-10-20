package Clase5.Tests;

import Clase5.Constants.AccountConstants;
import Clase5.Pages.AuthenticationPage;
import Clase5.Pages.MenuPage;
import Clase5.Pages.MyAccountPage;
import Clase5.Pages.RegisterNewAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterAccountHelper extends BaseTest {

    public WebDriver driver;

    public RegisterAccountHelper(WebDriver remoteDriver){
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
    }

    public MyAccountPage registerNewAccount() throws InterruptedException {

        MenuPage menuPage = new MenuPage(driver);

        AuthenticationPage authenticationPage = menuPage.clickOnSignInBtn();
        Assert.assertTrue(authenticationPage.getNavigationPanelPosition().equals("Authentication"), "No se encuentra en la pagina de authenticación");


        //Completo el mail
        authenticationPage.completeNewEmail(AccountConstants.ACCOUNT_EMAIL);

        RegisterNewAccountPage registerNewAccountPage = authenticationPage.clickOnCreateAccount();
        Thread.sleep(4000);

        Assert.assertTrue(registerNewAccountPage.getCreateAccountHeader().contains("CREATE AN ACCOUNT"), "No se ha ingresado a la pagina de creación de cuenta");

        System.out.println("email constant value" + AccountConstants.ACCOUNT_EMAIL);
        Assert.assertTrue(registerNewAccountPage.getEmailValue().equals(AccountConstants.ACCOUNT_EMAIL), "Los emails para crear la cuenta no coinciden");

        registerNewAccountPage.completeRegistrationForm();
        MyAccountPage myAccountPage = registerNewAccountPage.clickOnRegisterButton();

        Assert.assertTrue(myAccountPage.getNavigationPanelPosition().equals("My account"), "No se encuentra en la pagina correspondiente mi Cuenta");
        Assert.assertTrue(myAccountPage.getAccountHeader().contains("MY ACCOUNT"), "No se encuentra en la pagina correspondiente mi Cuenta");
        Assert.assertTrue(menuPage.getLoggedAccount().contains(AccountConstants.ACCOUNT_NAME_PERSON) && menuPage.getLoggedAccount().contains(AccountConstants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

        return myAccountPage;

    }
}
