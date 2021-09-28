package Clase4;

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

public class EcommerceFindByRefactor {


    public WebDriver driver;


    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        PageFactory.initElements(driver, this);
    }

    //Web Elements
    //Main menu
    @FindBy (className = "login")
    public WebElement signInButtonMenu;

    //AuthenticationPage
    @FindBy (className = "navigation_page")
    public WebElement navigationPanel;

    @FindBy (id = "email_create")
    public WebElement emailNewAccountField;

    @FindBy (id ="SubmitCreate")
    public  WebElement createAccountButton;

    @FindBy (className ="account")
    public  WebElement loggedAccountLabel;

    @FindBy (xpath = "//a[@title ='Information']")
    public  WebElement myPersonalInformationBtn;

    @FindBy (xpath = "(//* [@class='page-subheading'])[2]")
    public  WebElement loginSectionTitle;

    //Sign In Section in Authentication page
    @FindBy (id ="SubmitLogin")
    public  WebElement loginButton;

    @FindBy (id ="email")
    public  WebElement emailTextBox;

    @FindBy (id = "passwd")
    public WebElement passwordTextBox;


    //Login Validation Elements
    @FindBy (xpath = "//*[@id='create_account_error']/ol/li")
    public WebElement loginErrorMsgElement;

    //Registration Page
    @FindBy (className = "page-heading")
    public WebElement createAccountHeader;

    @FindBy (id = "email")
    public WebElement emailField;

    //set account data

    @FindBy (id = "uniform-id_gender1")
    public WebElement maleRadioButton;

    @FindBy (id = "customer_firstname")
    public WebElement accountFirstNameField;

    @FindBy (id = "customer_lastname")
    public WebElement accountLastNameField;

    @FindBy (id = "passwd")
    public WebElement accountPasswordField;

    @FindBy (id = "days")
    public WebElement dropDownBirthDay;

    @FindBy (id = "months")
    public WebElement dropDownBirthMonth;

    @FindBy (id = "years")
    public WebElement dropDownBirthYear;

    @FindBy (id = "company")
    public WebElement companyField;

    @FindBy (id = "address1")
    public WebElement addressField;

    @FindBy (id = "city")
    public WebElement cityField;

    @FindBy (id = "id_state")
    public WebElement dropDownStates;

    @FindBy (id = "postcode")
    public WebElement postalCodeField;

    @FindBy (id = "phone")
    public WebElement homePhoneField;

    @FindBy (id = "phone_mobile")
    public WebElement mobilePhoneField;

    @FindBy (id = "alias")
    public WebElement addressAliasField;

    @FindBy (id = "submitAccount")
    public WebElement submitRegisterAccountButton;

    //Log Out

    @FindBy (className = "logout")
    public WebElement logoutBtn;

    //My Personal Information
    @FindBy (id = "firstname")
    public WebElement myPersonalInformationNameElement;

    @FindBy (id = "lastname")
    public WebElement myPersonalInformationLastNameElement;



    @Test
    public void registrationProcessTest() throws InterruptedException {

        completeRegistration();

        //MyAccountPage
        Assert.assertTrue(navigationPanel.getText().equals("My account"), "No se encuentra en la pagina correspondiente mi Cuenta");
        //System.out.println(createAccountHeader.getText());
        Assert.assertTrue(createAccountHeader.getText().contains("MY ACCOUNT"), "No se encuentra en la pagina correspondiente mi Cuenta");
        //System.out.println(Constants.ACCOUNT_NAME_PERSON +" "+ Constants.ACCOUNT_LASTNAME_PERSON);
        Assert.assertTrue(loggedAccountLabel.getText().contains(Constants.ACCOUNT_NAME_PERSON) && loggedAccountLabel.getText().contains(Constants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

        // Verificar los datos de la cuenta creada.
        myPersonalInformationBtn.click();
        String actualNameAccount = myPersonalInformationNameElement.getAttribute("value");
        String actualLastNameAccount = myPersonalInformationLastNameElement.getAttribute("value");
        Assert.assertTrue(actualNameAccount.equals(Constants.ACCOUNT_NAME_PERSON), "los nombres no coinciden");
        Assert.assertTrue(actualLastNameAccount.equals(Constants.ACCOUNT_LASTNAME_PERSON), "los apellidos no coinciden");

        logOut();
    }

    @Test
    public void loginTest() throws InterruptedException {

        completeRegistration();
        logOut();

        //Sign In...
        System.out.println("Login Title ---->" + loginSectionTitle.getText());
        Assert.assertTrue(loginSectionTitle.getText().equals("ALREADY REGISTERED?"));
        Assert.assertTrue(loginButton.getText().equals("Sign in"));

        //Thread.sleep(2000);
        emailTextBox.sendKeys(Constants.ACCOUNT_EMAIL);
        passwordTextBox.sendKeys(Constants.ACCOUNT_PASSWORD);

        loginButton.click();

        System.out.println(Constants.ACCOUNT_NAME_PERSON +" "+ Constants.ACCOUNT_LASTNAME_PERSON);
        Assert.assertTrue(loggedAccountLabel.getText().contains(Constants.ACCOUNT_NAME_PERSON) && loggedAccountLabel.getText().contains(Constants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

    }

    @Test
    public void verifyExistingAccount() throws InterruptedException {

        completeRegistration();
        logOut();

       emailNewAccountField.sendKeys(Constants.ACCOUNT_EMAIL);
       createAccountButton.click();
       System.out.println(loginErrorMsgElement.getText());
       Assert.assertTrue(loginErrorMsgElement.getText().equals(Constants.EXISTING_ACCOUNT_MSG), "No se detecto el error");

    }


    public void completeRegistration() throws InterruptedException{

        //Main menu
        signInButtonMenu.click();

        //AuthenticationPage
        Assert.assertTrue(navigationPanel.getText().equals("Authentication"), "No se encuentra en la pagina de authenticación");
        emailNewAccountField.sendKeys(Constants.ACCOUNT_EMAIL);
        createAccountButton.click();

        Thread.sleep(3500);

        //Registration Page
        //WebElement createAccountHeader = driver.findElement(By.className("page-heading"));
        System.out.println("Header--->" + createAccountHeader.getText());
        Assert.assertTrue(createAccountHeader.getText().contains("CREATE AN ACCOUNT"), "No se ha ingresado a la pagina de creación de cuenta");

        //WebElement emailField = driver.findElement((By.xpath("//*[@id='email']")));
        System.out.println("email page value--->" + emailField.getAttribute("value"));
        System.out.println("email constant value" + Constants.ACCOUNT_EMAIL);
        Thread.sleep(1000);
        Assert.assertTrue(emailField.getAttribute("value").equals(Constants.ACCOUNT_EMAIL));

        //Complete registration
        maleRadioButton.click();
        accountFirstNameField.sendKeys(Constants.ACCOUNT_NAME_PERSON);
        accountLastNameField.sendKeys(Constants.ACCOUNT_LASTNAME_PERSON);
        accountPasswordField.sendKeys(Constants.ACCOUNT_PASSWORD);

        Select selectDropDownBirthDay = new Select(dropDownBirthDay);
        selectDropDownBirthDay.selectByValue(Constants.ACCOUNT_BIRTHDAY_DAY);

        Select selectDropDownBirthMonth = new Select(dropDownBirthMonth);
        selectDropDownBirthMonth.selectByValue(Constants.ACCOUNT_BIRTHDAY_MONTH);

        Select selectDropDownBirthYear = new Select(dropDownBirthYear);
        selectDropDownBirthYear.selectByValue(Constants.ACCOUNT_BIRTHDAY_YEAR);

        companyField.sendKeys(Constants.NAME_COMPANY);
        addressField.sendKeys(Constants.ACCOUNT_ADDRESS);
        cityField.sendKeys(Constants.ACCOUNT_CITY);

        Select selectDropDownStates = new Select(dropDownStates);
        selectDropDownStates.selectByVisibleText(Constants.ACCOUNT_STATE);

        postalCodeField.sendKeys(Constants.ACCOUNT_POSTCODE);
        homePhoneField.sendKeys(Constants.ACCOUNT_PHONE);
        mobilePhoneField.sendKeys(Constants.ACCOUNT_MOBILEPHONE);
        addressAliasField.sendKeys(Constants.ACCOUNT_ALIAS);
        submitRegisterAccountButton.click();

    }

    public void logOut(){

        Assert.assertTrue(logoutBtn.getText().equals("Sign out"), "El sistema no se encuentra logueado");
        logoutBtn.click();

    }

    @AfterMethod
    public void CloseDriver(){
       driver.close();
    }

}
