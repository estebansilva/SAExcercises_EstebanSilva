package Clase5.Pages;

;
import Clase5.Constants.AccountConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Refactorizar {


    public WebDriver driver;


    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        PageFactory.initElements(driver, this);
    }

    //Web Elements
    //Main menu
    @FindBy(className = "login")
    public WebElement signInButtonMenu;

    //AuthenticationPage
    @FindBy(className = "navigation_page")
    public WebElement navigationPanel;

    @FindBy(id = "email_create")
    public WebElement emailNewAccountField;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(className = "account")
    public WebElement loggedAccountLabel;

    @FindBy(xpath = "//a[@title ='Information']")
    public WebElement myPersonalInformationBtn;

    @FindBy(xpath = "(//* [@class='page-subheading'])[2]")
    public WebElement loginSectionTitle;

    //Sign In Section in Authentication page
    @FindBy(id = "SubmitLogin")
    public WebElement loginButton;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "passwd")
    public WebElement passwordTextBox;


    //Login Validation Elements
    @FindBy(xpath = "//*[@id='create_account_error']/ol/li")
    public WebElement loginErrorMsgElement;

    //Registration Page
    @FindBy(className = "page-heading")
    public WebElement createAccountHeader;

    @FindBy(id = "email")
    public WebElement emailField;

    //set account data

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

    //Log Out

    @FindBy(className = "logout")
    public WebElement logoutBtn;

    //My Personal Information
    @FindBy(id = "firstname")
    public WebElement myPersonalInformationNameElement;

    @FindBy(id = "lastname")
    public WebElement myPersonalInformationLastNameElement;


    @Test
    public void registrationProcessTest() throws InterruptedException {

        completeRegistration();

        //MyAccountPage
        //Assert.assertTrue(navigationPanel.getText().equals("My account"), "No se encuentra en la pagina correspondiente mi Cuenta");
        //System.out.println(createAccountHeader.getText());
        //Assert.assertTrue(createAccountHeader.getText().contains("MY ACCOUNT"), "No se encuentra en la pagina correspondiente mi Cuenta");
        //System.out.println(Constants.ACCOUNT_NAME_PERSON +" "+ Constants.ACCOUNT_LASTNAME_PERSON);
        //Assert.assertTrue(loggedAccountLabel.getText().contains(AccountConstants.ACCOUNT_NAME_PERSON) && loggedAccountLabel.getText().contains(AccountConstants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

        // Verificar los datos de la cuenta creada.
        //myPersonalInformationBtn.click();
        //String actualNameAccount = myPersonalInformationNameElement.getAttribute("value");
        //String actualLastNameAccount = myPersonalInformationLastNameElement.getAttribute("value");
        //Assert.assertTrue(actualNameAccount.equals(AccountConstants.ACCOUNT_NAME_PERSON), "los nombres no coinciden");
        //Assert.assertTrue(actualLastNameAccount.equals(AccountConstants.ACCOUNT_LASTNAME_PERSON), "los apellidos no coinciden");

        logOut();
    }

    @Test
    public void loginTest() throws InterruptedException {

       /* completeRegistration();
        logOut();

        //Sign In...
        System.out.println("Login Title ---->" + loginSectionTitle.getText());
        Assert.assertTrue(loginSectionTitle.getText().equals("ALREADY REGISTERED?"));
        Assert.assertTrue(loginButton.getText().equals("Sign in"));*/

        //Thread.sleep(2000);
        emailTextBox.sendKeys(AccountConstants.ACCOUNT_EMAIL);
        passwordTextBox.sendKeys(AccountConstants.ACCOUNT_PASSWORD);

        loginButton.click();

        System.out.println(AccountConstants.ACCOUNT_NAME_PERSON + " " + AccountConstants.ACCOUNT_LASTNAME_PERSON);
        Assert.assertTrue(loggedAccountLabel.getText().contains(AccountConstants.ACCOUNT_NAME_PERSON) && loggedAccountLabel.getText().contains(AccountConstants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

    }

    @Test
    public void verifyExistingAccount() throws InterruptedException {

        completeRegistration();
        logOut();

        emailNewAccountField.sendKeys(AccountConstants.ACCOUNT_EMAIL);
        createAccountButton.click();
        System.out.println(loginErrorMsgElement.getText());
        Assert.assertTrue(loginErrorMsgElement.getText().equals(AccountConstants.EXISTING_ACCOUNT_MSG), "No se detecto el error");

    }


    public void completeRegistration() throws InterruptedException {

        //Main menu
        //signInButtonMenu.click();

        //AuthenticationPage
        //Assert.assertTrue(navigationPanel.getText().equals("Authentication"), "No se encuentra en la pagina de authenticación");
        //emailNewAccountField.sendKeys(AccountConstants.ACCOUNT_EMAIL);
        //createAccountButton.click();

        Thread.sleep(3500);

        //Registration Page
        //WebElement createAccountHeader = driver.findElement(By.className("page-heading"));
        //System.out.println("Header--->" + createAccountHeader.getText());
        //Assert.assertTrue(createAccountHeader.getText().contains("CREATE AN ACCOUNT"), "No se ha ingresado a la pagina de creación de cuenta");

        //WebElement emailField = driver.findElement((By.xpath("//*[@id='email']")));
        //System.out.println("email page value--->" + emailField.getAttribute("value"));
        //System.out.println("email constant value" + AccountConstants.ACCOUNT_EMAIL);
        //Thread.sleep(1000);
        //Assert.assertTrue(emailField.getAttribute("value").equals(AccountConstants.ACCOUNT_EMAIL));

        //Complete registration
        //maleRadioButton.click();
       // accountFirstNameField.sendKeys(AccountConstants.ACCOUNT_NAME_PERSON);
        //accountLastNameField.sendKeys(AccountConstants.ACCOUNT_LASTNAME_PERSON);
        //accountPasswordField.sendKeys(AccountConstants.ACCOUNT_PASSWORD);

        //Select selectDropDownBirthDay = new Select(dropDownBirthDay);
        //selectDropDownBirthDay.selectByValue(AccountConstants.ACCOUNT_BIRTHDAY_DAY);

        //Select selectDropDownBirthMonth = new Select(dropDownBirthMonth);
        //selectDropDownBirthMonth.selectByValue(AccountConstants.ACCOUNT_BIRTHDAY_MONTH);

        //Select selectDropDownBirthYear = new Select(dropDownBirthYear);
        //selectDropDownBirthYear.selectByValue(AccountConstants.ACCOUNT_BIRTHDAY_YEAR);

        //companyField.sendKeys(AccountConstants.NAME_COMPANY);
        //addressField.sendKeys(AccountConstants.ACCOUNT_ADDRESS);
        //cityField.sendKeys(AccountConstants.ACCOUNT_CITY);

        //Select selectDropDownStates = new Select(dropDownStates);
        //selectDropDownStates.selectByVisibleText(AccountConstants.ACCOUNT_STATE);

        //postalCodeField.sendKeys(AccountConstants.ACCOUNT_POSTCODE);
        //homePhoneField.sendKeys(AccountConstants.ACCOUNT_PHONE);
        //mobilePhoneField.sendKeys(AccountConstants.ACCOUNT_MOBILEPHONE);
        //addressAliasField.sendKeys(AccountConstants.ACCOUNT_ALIAS);
        //submitRegisterAccountButton.click();

    }

    public void logOut() {

       // Assert.assertTrue(logoutBtn.getText().equals("Sign out"), "El sistema no se encuentra logueado");
        //logoutBtn.click();

    }

    @AfterMethod
    public void CloseDriver() {
        driver.close();
    }

}


