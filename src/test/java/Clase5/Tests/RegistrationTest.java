package Clase5.Tests;

import Clase5.Constants.AccountConstants;
import Clase5.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void registerNewAccountTest() throws InterruptedException {

        //Ingreso al sitio
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

        menuPage.clickOnSignOutBtn();

    }

    @Test
    public void registerWithExistingAccount() throws InterruptedException {

        //Ingreso al sitio
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
        authenticationPage.completeNewEmail(AccountConstants.ACCOUNT_EMAIL);
        authenticationPage.clickOnCreateAccount();
        System.out.println(authenticationPage.getLoginErrorMsgElement());
        Assert.assertTrue(authenticationPage.getLoginErrorMsgElement().equals(AccountConstants.EXISTING_ACCOUNT_MSG), "No se detecto el error");

    }


}
