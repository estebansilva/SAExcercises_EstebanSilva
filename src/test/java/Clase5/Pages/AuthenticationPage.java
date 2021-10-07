package Clase5.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    //Constructor
    public AuthenticationPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    //FindBys
    @FindBy(className = "navigation_page")
    public WebElement navigationPanel;

    @FindBy(id = "email_create")
    public WebElement emailNewAccountField;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(xpath = "(//* [@class='page-subheading'])[2]")
    public WebElement loginSectionTitle;

    @FindBy(id = "SubmitLogin")
    public WebElement loginButton;

    @FindBy(id = "email")
    public WebElement emailLoginField;

    @FindBy(id = "passwd")
    public WebElement passwordLoginField;

    @FindBy(xpath = "//*[@id='create_account_error']/ol/li")
    public WebElement loginErrorMsgElement;


    public String getNavigationPanelPosition() {
        return navigationPanel.getText();
    }

    public void completeNewEmail(String accountEmail) {
        emailNewAccountField.sendKeys(accountEmail);
    }


    public RegisterNewAccountPage clickOnCreateAccount() {
        waitVisibility(createAccountButton);
        createAccountButton.click();
        RegisterNewAccountPage registerNewAccountPage = new RegisterNewAccountPage(driver);
        return registerNewAccountPage;
    }

    public String getLoginSectionTitle() {
        System.out.println("Login Title ---->" + loginSectionTitle.getText());
        return loginSectionTitle.getText();
    }

    public String getLoginButtonText() {
        return loginButton.getText();

    }

    public void completeLoginEmailAndPassword(String accountEmail, String accountPassword) {
        emailLoginField.sendKeys(accountEmail);
        passwordLoginField.sendKeys(accountPassword);
    }

    public MyAccountPage clickOnSignInButton() {

        loginButton.click();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        return myAccountPage;
    }

    public String getLoginErrorMsgElement() {

        return loginErrorMsgElement.getText();
    }
}
