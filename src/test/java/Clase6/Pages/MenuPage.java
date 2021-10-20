package Clase6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuPage extends BasePage {

    //public WebDriver driver;

    //Constructor
    public MenuPage(WebDriver remoteDriver) {
        super(remoteDriver);

    }

    //FindBy
    @FindBy(className = "login")
    public WebElement signInButtonMenu;

    @FindBy(className = "account")
    public WebElement loggedAccountLabel;

    @FindBy(className = "logout")
    public WebElement logoutBtn;

    @FindBy(id = "search_query_top")
    public WebElement searchBar;

    @FindBy (css = "button[name=\"submit_search\"]")
    public WebElement searchButton;

    public AuthenticationPage clickOnSignInBtn() {

        signInButtonMenu.click();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        return authenticationPage;

    }

    public String getLoggedAccount() {
        System.out.println(loggedAccountLabel.getText());
        return loggedAccountLabel.getText();
    }

    public AuthenticationPage clickOnSignOutBtn() {

        Assert.assertTrue(logoutBtn.getText().equals("Sign out"), "El sistema no se encuentra logueado");
        logoutBtn.click();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        return authenticationPage;

    }

    public String getloggedAccountLabel(){
        return loggedAccountLabel.getText();
    }

    public GrillProductPage searchAProduct(String searchTextProduct) {

        searchBar.sendKeys(searchTextProduct);
        searchButton.click();

        //waiting for the Search page
        waitTitleContains("Search");
        GrillProductPage grillProductPage = new GrillProductPage(driver);
        return grillProductPage;
    }
}
