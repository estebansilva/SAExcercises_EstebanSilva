package Clase5.Tests;

import Clase5.Constants.AccountConstants;
import Clase5.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void validLoginTest() throws InterruptedException{

        LandingPage landingPage = new LandingPage(driver);
        landingPage.GoHomePage();

        RegisterAccountHelper registerAccountHelper = new RegisterAccountHelper(driver);
        MyAccountPage myAccountPage = registerAccountHelper.registerNewAccount();

        Assert.assertTrue(myAccountPage.getNavigationPanelPosition().equals("My account"), "No se encuentra en la pagina correspondiente mi Cuenta");
        Assert.assertTrue(myAccountPage.getAccountHeader().contains("MY ACCOUNT"), "No se encuentra en la pagina correspondiente mi Cuenta");

        MenuPage menuPage = new MenuPage(driver);
        Assert.assertTrue(menuPage.getLoggedAccount().contains(AccountConstants.ACCOUNT_NAME_PERSON) && menuPage.getLoggedAccount().contains(AccountConstants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

        MyPersonalInformationPage myPersonalInformationPage = myAccountPage.clickOnMyPersonalInformationButton();
        Assert.assertTrue(myPersonalInformationPage.getActualFirstNameAccount().equals(AccountConstants.ACCOUNT_NAME_PERSON), "El nombre no coincide");
        Assert.assertTrue(myPersonalInformationPage.getActualLastNameAccount().equals(AccountConstants.ACCOUNT_LASTNAME_PERSON), "El apellido no coincide");

        AuthenticationPage authenticationPage = menuPage.clickOnSignOutBtn();
        Assert.assertTrue(authenticationPage.getLoginSectionTitle().equals("ALREADY REGISTERED?"), "No se encuentra el titulo de la sección de logueo");
        Assert.assertTrue(authenticationPage.getLoginButtonText().equals("Sign in"), "No se encuentra el botón Sign In");

        authenticationPage.completeLoginEmailAndPassword(AccountConstants.ACCOUNT_EMAIL, AccountConstants.ACCOUNT_PASSWORD);

        // Al hacer click aquí el sistema vuelve a authenticationPage (se necesita levantar el constructor de nuevo?)
        authenticationPage.clickOnSignInButton();

        System.out.println(AccountConstants.ACCOUNT_NAME_PERSON + " " + AccountConstants.ACCOUNT_LASTNAME_PERSON);
        Assert.assertTrue(menuPage.getloggedAccountLabel().contains(AccountConstants.ACCOUNT_NAME_PERSON)&& menuPage.getloggedAccountLabel().contains(AccountConstants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

    }


}
