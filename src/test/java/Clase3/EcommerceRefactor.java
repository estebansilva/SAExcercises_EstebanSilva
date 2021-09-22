package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class EcommerceRefactor {



    public WebDriver driver;


    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void registrationProcessTest() throws InterruptedException {

        completeRegistration();
        //MyAccountPage
        Assert.assertTrue(driver.findElement(By.className("navigation_page")).getText().equals("My account"), "No se encuentra en la pagina correspondiente mi Cuenta");

        WebElement createAccountHeader = driver.findElement(By.className("page-heading"));
        System.out.println(createAccountHeader.getText());
        Assert.assertTrue(createAccountHeader.getText().contains("MY ACCOUNT"), "No se encuentra en la pagina correspondiente mi Cuenta");

        WebElement loggedAccountLabel = driver.findElement(By.className("account"));
        System.out.println(Constants.ACCOUNT_NAME_PERSON +" "+ Constants.ACCOUNT_LASTNAME_PERSON);
        Assert.assertTrue(loggedAccountLabel.getText().contains(Constants.ACCOUNT_NAME_PERSON) && loggedAccountLabel.getText().contains(Constants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

        // Verificar los datos de la cuenta creada.
        WebElement myPersonalInformationBtn = driver.findElement(By.xpath("//a[@title ='Information']"));
        myPersonalInformationBtn.click();

        WebElement myPersonalInformationNameElement = driver.findElement((By.id("firstname")));
        WebElement myPersonalInformationLastNameElement = driver.findElement((By.id("lastname")));

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
        WebElement loginSectionTitle = driver.findElement(By.xpath("(//* [@class='page-subheading'])[2]"));
        System.out.println("Login Title ---->" + loginSectionTitle.getText());
        Assert.assertTrue(loginSectionTitle.getText().equals("ALREADY REGISTERED?"));
        WebElement loginButton = driver.findElement((By.id("SubmitLogin")));
        Assert.assertTrue(loginButton.getText().equals("Sign in"));

        //Thread.sleep(2000);
        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys(Constants.ACCOUNT_EMAIL);
        //Thread.sleep(2000);
        WebElement passwordTextBox = driver.findElement(By.id("passwd"));
        passwordTextBox.sendKeys(Constants.ACCOUNT_PASSWORD);

        //Thread.sleep(2000);
        loginButton.click();

        //Thread.sleep(3000);
        System.out.println(Constants.ACCOUNT_NAME_PERSON +" "+ Constants.ACCOUNT_LASTNAME_PERSON);
        //Thread.sleep(3000);
        WebElement loggedAccountLabel = driver.findElement(By.className("account"));
        Assert.assertTrue(loggedAccountLabel.getText().contains(Constants.ACCOUNT_NAME_PERSON) && loggedAccountLabel.getText().contains(Constants.ACCOUNT_LASTNAME_PERSON), "No es el usuario loggueado");

    }

    @Test
    public void verifyExistingAccount() throws InterruptedException {

        completeRegistration();
        logOut();

        WebElement emailNewAccountField = driver.findElement(By.id("email_create"));
        emailNewAccountField.sendKeys(Constants.ACCOUNT_EMAIL);

        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        WebElement loginErrorMsgElement = driver.findElement(By.xpath("//*[@id='create_account_error']/ol/li"));
        System.out.println(loginErrorMsgElement.getText());
        Assert.assertTrue(loginErrorMsgElement.getText().equals("An account using this email address has already been registered. Please enter a valid password or request a new one."), "No se detecto el error");

    }


    public void completeRegistration() throws InterruptedException{

        //Main menu
        WebElement signInButtonMenu = driver.findElement(By.className("login"));
        signInButtonMenu.click();

        //AuthenticationPage
        Assert.assertTrue(driver.findElement(By.className("navigation_page")).getText().equals("Authentication"), "No se encuentra en la pagina de authenticación");


        WebElement emailNewAccountField = driver.findElement(By.id("email_create"));
        emailNewAccountField.sendKeys(Constants.ACCOUNT_EMAIL);

        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        Thread.sleep(3500);

        //Registration Page
        WebElement createAccountHeader = driver.findElement(By.className("page-heading"));
        System.out.println("Header--->" + createAccountHeader.getText());
        Assert.assertTrue(createAccountHeader.getText().contains("CREATE AN ACCOUNT"), "No se ha ingresado a la pagina de creación de cuenta");

        WebElement emailField = driver.findElement((By.xpath("//*[@id='email']")));
        System.out.println("email page value--->" + emailField.getAttribute("value"));
        System.out.println("email constant value" + Constants.ACCOUNT_EMAIL);
        Thread.sleep(1000);
        Assert.assertTrue(emailField.getAttribute("value").equals(Constants.ACCOUNT_EMAIL));

        //set account data
        //Web Elements
        WebElement maleRadioButton = driver.findElement(By.id("uniform-id_gender1"));
        WebElement accountFirstNameField = driver.findElement(By.id("customer_firstname"));
        WebElement accountLastNameField = driver.findElement(By.id("customer_lastname"));
        WebElement accountPasswordField = driver.findElement((By.id("passwd")));
        WebElement dropDownBirthDay = driver.findElement(By.id("days"));
        WebElement dropDownBirthMonth = driver.findElement(By.id("months"));
        WebElement dropDownBirthYear = driver.findElement(By.id("years"));
        WebElement companyField = driver.findElement((By.id("company")));
        WebElement addressField = driver.findElement(By.id("address1"));
        WebElement cityField = driver.findElement(By.id("city"));
        WebElement dropDownStates = driver.findElement(By.id("id_state"));
        WebElement postalCodeField = driver.findElement(By.id("postcode"));
        WebElement homePhoneField = driver.findElement((By.id("phone")));
        WebElement mobilePhoneField = driver.findElement(By.id("phone_mobile"));
        WebElement addressAliasField = driver.findElement(By.id("alias"));

        WebElement submitRegisterAccountButton = driver.findElement(By.id("submitAccount"));

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

        WebElement logoutBtn = driver.findElement(By.className("logout"));
        Assert.assertTrue(logoutBtn.getText().equals("Sign out"), "El sistema no se encuentra logueado");
        logoutBtn.click();

    }

    @AfterMethod
    public void CloseDriver(){
        driver.close();
    }

}


