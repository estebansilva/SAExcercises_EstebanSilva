package Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindByEmailChimp {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.mailchimp.com/signup/");


        PageFactory.initElements(driver, this);

    }

    @FindBy (id = "onetrust-close-btn-container")
    public WebElement closeCookiesButton;

    @FindBy (xpath = "//*[@class='signup-wrap lastUnit']/h1")
    public WebElement welcomeTitleElement;

    @FindBy (className = "hide-phone")
    public WebElement welcomeParagraphElement;

    @FindBy (xpath = "//*[@class='hide-phone']/a")
    public WebElement logInLinkElement;

    @FindBy (id = "email")
    public WebElement emailField;

    @FindBy (id = "new_username")
    public WebElement usernameField;

    @FindBy (id = "new_password")
    public WebElement passwordField;

    @FindBy (className = "8-char")
    public WebElement eightCharacterText;

    @Test
    public void MailchimpTest() throws InterruptedException {

        //Cierro las cookies
        closeCookies();

        //Valido que se encuentre el texto Welcome to Mailchimp.
        System.out.print(welcomeTitleElement.getText());
        Assert.assertTrue(welcomeTitleElement.getText().equals("Welcome to Mailchimp"));

        //Valido que se encuentre el texto Already have an account?
        System.out.println(welcomeParagraphElement.getText());
        Assert.assertTrue(welcomeParagraphElement.getText().contains("Already have an account?"));

        //Valido que existe el link Log In
        System.out.println(logInLinkElement.getText());
        Assert.assertTrue(logInLinkElement.getText().equals("Log in"));



        //Completo los campos
        emailField.sendKeys(Constants.ACCOUNT_EMAIL);
        usernameField.sendKeys(Constants.ACCOUNT_NAME_PERSON);
        passwordField.sendKeys(Constants.ACCOUNT_PASSWORD);

        //Valido que exista algunos de los textos
        System.out.println(eightCharacterText.getText());
        Assert.assertTrue(eightCharacterText.getText().equals("8 characters minimum"));


    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

    public void closeCookies(){

        closeCookiesButton.click();

    }
}
