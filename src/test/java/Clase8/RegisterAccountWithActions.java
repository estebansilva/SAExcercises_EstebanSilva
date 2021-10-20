package Clase8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterAccountWithActions {

    //Variables
    public WebDriver driver;
    public WebDriverWait wait;
    String siteURL = "http://automationpractice.com/index.php";
    String emailString = "testing+" + Math.random() + "@gmail.com";

    //FindBys
    @FindBy (className = "login")
    public WebElement loginBtn;

    @FindBy (tagName = "h1")
    public By TitlePage;

    @FindBy (id = "email_create")
    public WebElement emailTextBox;

    @FindBy (id = "SubmitCreate")
    public WebElement createAccountBtn;
//locating all the form fields, this is only possible because the form with fields already loaded by this time so you have the locators working, helps to better reading

    @FindBy (id = "id_gender1") public WebElement maleRadioButton;
    @FindBy (id =  "customer_firstname") public WebElement firstName;
    @FindBy (id = "customer_lastname") public WebElement lastName;
    @FindBy (id = "passwd") public WebElement password;
    @FindBy (id = "days") public WebElement daySelector;
    @FindBy (id = "months") public WebElement monthSelector;
    @FindBy (id = "years") public WebElement yearSelector;
    @FindBy (id = "company") public WebElement company;
    @FindBy (id = "address1") public WebElement address1;
    @FindBy (id = "address2") public WebElement address2;
    @FindBy (id = "city") public WebElement city;
    @FindBy (id = "id_state") public WebElement stateSelector;
    @FindBy (id = "postcode") public WebElement postcode;
    @FindBy (id = "id_country") public WebElement countrySelector;
    @FindBy (id = "other") public WebElement additionalInfo;
    @FindBy (id = "phone") public WebElement phone;
    @FindBy (id = "phone_mobile") public WebElement mobile;
    @FindBy (id = "alias") public WebElement addressAlias;
    @FindBy (id = "submitAccount") public WebElement registerButton;

    @FindBy (className = "icon-user")
    public WebElement userInformationButton;

    @FindBy(id = "firstname")
    public WebElement myPersonalInformationNameElement;

    @FindBy(id = "lastname")
    public WebElement myPersonalInformationLastNameElement;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       // driver.get("http://automationpractice.com/index.php");
        PageFactory.initElements(driver, this);
    }

    @Test
    public void registerAccountWithActions() throws InterruptedException {
        Actions actions = new Actions(driver);

        //Crear un método que ingrese a http://automationpractice.com/index.php.
        driver.get(siteURL);
        Thread.sleep(100);
        //waiting for the SignIn button to be clickable, otherwise it will fail
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("login"))));

        //clicking the SignIn button
        Action loginBtnAction = actions
                .click(loginBtn)
                .build();

        loginBtnAction.perform();

        //waiting until the h1 element is visible on the site “Authentication”
        //wait.until(ExpectedConditions.visibilityOfElementLocated(TitlePage));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        //searching for the email field and sending a random value
        //click on the submit button
        Action initializeNewAccountAction = actions
                .moveToElement(emailTextBox).click().sendKeys(emailString)
                .moveToElement(createAccountBtn).click(createAccountBtn)
                .build();

        initializeNewAccountAction.perform();

        //waiting for the form to load completely
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-creation_form")));

        //start interacting with the fields and sending the respective values

        Action completeForm = actions
                .click(maleRadioButton)
                .moveToElement(firstName).click().sendKeys(Constants.ACCOUNT_NAME_PERSON)
                .moveToElement(lastName).click().sendKeys(Constants.ACCOUNT_LASTNAME_PERSON)
                .moveToElement(password).click().sendKeys(Constants.ACCOUNT_PASSWORD)
                .moveToElement(company).click().sendKeys(Constants.NAME_COMPANY)
                .moveToElement(address1).click().sendKeys(Constants.ACCOUNT_ADDRESS)
                .moveToElement(address2).click().sendKeys(Constants.ACCOUNT_ADDRESS)
                .moveToElement(city).click().sendKeys(Constants.ACCOUNT_CITY)
                .moveToElement(postcode).click().sendKeys(Constants.ACCOUNT_POSTCODE)
                .moveToElement(additionalInfo).click().sendKeys("Additional information")
                .moveToElement(phone).click().sendKeys(Constants.ACCOUNT_PHONE)
                .moveToElement(mobile).click().sendKeys(Constants.ACCOUNT_MOBILEPHONE)
                .moveToElement(addressAlias).click().sendKeys(Constants.ACCOUNT_ALIAS)
                .build();

        completeForm.perform();

        Select selectDays = new Select(daySelector);
        selectDays.selectByValue(Constants.ACCOUNT_BIRTHDAY_DAY);
        Select selectMonths = new Select(monthSelector);
        selectMonths.selectByValue(Constants.ACCOUNT_BIRTHDAY_MONTH);
        Select selectYears = new Select(yearSelector);
        selectYears.selectByValue(Constants.ACCOUNT_BIRTHDAY_YEAR);

        Select selectState = new Select(stateSelector);
        selectState.selectByValue("2");

        Select selectCountry = new Select(countrySelector);
        selectCountry.selectByValue("21");

        //clicking on register button
        Action clickOnRegisterBtnAction = actions
                .click(registerButton)
                .build();

        clickOnRegisterBtnAction.perform();


        //flow to validate the correct information
        //waiting to see the account page
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "MY ACCOUNT"));

        //clicking on the personal information button in order to validate the information inserted previously
        Action clickOnUserInformationButtonAction = actions
                .click(userInformationButton)
                .build();
        clickOnUserInformationButtonAction.perform();

        //waiting to load all the data in the personal information page
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "YOUR PERSONAL INFORMATION"));
        Assert.assertTrue(myPersonalInformationNameElement.getAttribute("value").equals(Constants.ACCOUNT_NAME_PERSON), "El nombre no coincide");
        Assert.assertTrue(myPersonalInformationLastNameElement.getAttribute("value").equals(Constants.ACCOUNT_LASTNAME_PERSON), "El apellido no coincide");
    }

}
