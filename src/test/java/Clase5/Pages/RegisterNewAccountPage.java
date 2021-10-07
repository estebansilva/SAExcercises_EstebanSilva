package Clase5.Pages;

import Clase5.Constants.AccountConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterNewAccountPage extends BasePage {

    //Constructor
    public RegisterNewAccountPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    //FindBy
    @FindBy(className = "page-heading")
    public WebElement createAccountHeader;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "uniform-id_gender1")
    public WebElement maleRadioButton;

    @FindBy(id = "customer_firstname")
    public WebElement accountFirstNameField;

    @FindBy(id = "customer_lastname")
    public WebElement accountLastNameField;

    @FindBy(id = "passwd")
    public WebElement accountPasswordField;

    @FindBy(id = "days")
    public WebElement dropDownBirthDay;

    @FindBy(id = "months")
    public WebElement dropDownBirthMonth;

    @FindBy(id = "years")
    public WebElement dropDownBirthYear;

    @FindBy(id = "company")
    public WebElement companyField;

    @FindBy(id = "address1")
    public WebElement addressField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "id_state")
    public WebElement dropDownStates;

    @FindBy(id = "postcode")
    public WebElement postalCodeField;

    @FindBy(id = "phone")
    public WebElement homePhoneField;

    @FindBy(id = "phone_mobile")
    public WebElement mobilePhoneField;

    @FindBy(id = "alias")
    public WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    public WebElement submitRegisterAccountButton;


    //Methods
    public String getCreateAccountHeader() throws InterruptedException {
        Thread.sleep(5500);
        waitVisibility(createAccountHeader);
        System.out.println("Header--->" + createAccountHeader.getText());
        return createAccountHeader.getText();
    }


    public String getEmailValue() {
        waitVisibility(emailField);
        System.out.println("email page value--->" + emailField.getAttribute("value"));
        return emailField.getAttribute("value");
    }

    public void completeRegistrationForm() {

        maleRadioButton.click();
        accountFirstNameField.sendKeys(AccountConstants.ACCOUNT_NAME_PERSON);
        accountLastNameField.sendKeys(AccountConstants.ACCOUNT_LASTNAME_PERSON);
        accountPasswordField.sendKeys(AccountConstants.ACCOUNT_PASSWORD);

        Select selectDropDownBirthDay = new Select(dropDownBirthDay);
        selectDropDownBirthDay.selectByValue(AccountConstants.ACCOUNT_BIRTHDAY_DAY);

        Select selectDropDownBirthMonth = new Select(dropDownBirthMonth);
        selectDropDownBirthMonth.selectByValue(AccountConstants.ACCOUNT_BIRTHDAY_MONTH);

        Select selectDropDownBirthYear = new Select(dropDownBirthYear);
        selectDropDownBirthYear.selectByValue(AccountConstants.ACCOUNT_BIRTHDAY_YEAR);

        companyField.sendKeys(AccountConstants.NAME_COMPANY);
        addressField.sendKeys(AccountConstants.ACCOUNT_ADDRESS);
        cityField.sendKeys(AccountConstants.ACCOUNT_CITY);

        Select selectDropDownStates = new Select(dropDownStates);
        selectDropDownStates.selectByVisibleText(AccountConstants.ACCOUNT_STATE);

        postalCodeField.sendKeys(AccountConstants.ACCOUNT_POSTCODE);
        homePhoneField.sendKeys(AccountConstants.ACCOUNT_PHONE);
        mobilePhoneField.sendKeys(AccountConstants.ACCOUNT_MOBILEPHONE);
        addressAliasField.sendKeys(AccountConstants.ACCOUNT_ALIAS);

    }

    public MyAccountPage clickOnRegisterButton() {

        submitRegisterAccountButton.click();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        return myAccountPage;

    }
}
