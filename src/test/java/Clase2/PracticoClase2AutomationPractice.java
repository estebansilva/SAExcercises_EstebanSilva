package Clase2;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

//Preguntar por la clase faker

public class PracticoClase2AutomationPractice {

    public WebDriver driver;
    public Faker fakesDate = new Faker();

    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void registrationProcess() throws InterruptedException {
       //ToUseFaker
        String accountNamePerson = fakesDate.name().firstName();
        String accountLastNamePerson = fakesDate.name().lastName();
        String accountPassword = "12345678";



        //Main menu
        WebElement signInButtonMenu = driver.findElement(By.className("login"));
        signInButtonMenu.click();

        //AuthenticationPage
        Assert.assertTrue(driver.findElement(By.className("navigation_page")).getText().equals("Authentication"), "No se encuentra en la pagina de authenticación");

        String emailAccount = "firstname"+"lastname"+Math.random()+"@"+"mail.com";
        WebElement emailNewAccountField = driver.findElement(By.id("email_create"));
        emailNewAccountField.sendKeys(emailAccount);

        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();

        Thread.sleep(3000);

        //Registration Page
        WebElement createAccountHeader = driver.findElement(By.className("page-heading"));
        System.out.println(createAccountHeader.getText());
        Assert.assertTrue(createAccountHeader.getText().contains("CREATE AN ACCOUNT"), "No se ha ingresado a la pagina de creación de cuenta");

        WebElement emailField = driver.findElement((By.xpath("//*[@id='email']")));
        //System.out.println(emailField.getAttribute("value"));
        //System.out.println(emailAccount);
        Thread.sleep(1000);
        Assert.assertTrue(emailField.getAttribute("value").equals(emailAccount));

        //set account data

        WebElement maleRadioButton = driver.findElement(By.id("uniform-id_gender1"));
        maleRadioButton.click();

        WebElement accountFirstNameField = driver.findElement(By.id("customer_firstname"));
        accountFirstNameField.sendKeys(accountNamePerson);

        WebElement accountLastNameField = driver.findElement(By.id("customer_lastname"));
        accountLastNameField.sendKeys(accountLastNamePerson);

        WebElement accountPasswordField = driver.findElement((By.id("passwd")));
        accountPasswordField.sendKeys(accountPassword);

        /*WebElement addressFirstNameField = driver.findElement(By.id("firstname"));
        addressFirstNameField.click();
        addressFirstNameField.sendKeys("UserFirstName");

        WebElement lastNameField = driver.findElement(By.id("lastname"));
        lastNameField.click();
        lastNameField.sendKeys("UserLastName");*/

        WebElement companyField = driver.findElement((By.id("company")));
        companyField.sendKeys("CompanyName");

        WebElement addressField = driver.findElement(By.id("address1"));
        //addressField.click();
        addressField.sendKeys("addressField 451");

        WebElement cityField = driver.findElement(By.id("city"));
        //cityField.click();
        cityField.sendKeys("cityField");

        Select dropDownStates = new Select(driver.findElement(By.id("id_state")));
        dropDownStates.selectByVisibleText("Delaware");

        /*WebElement stateComboBox = driver.findElement(By.id("id_state"));
        stateComboBox.click();


        List<WebElement> listOfStateOptions = stateComboBox.findElements(By.("value"));
        for(WebElement option : listOfStateOptions){
            System.out.println(option.getText());
            if (option.getText().equals("Delaware")){
                System.out.println(option.getText());
                option.click();
                break;
            }
        }*/

        WebElement postalCodeField = driver.findElement(By.id("postcode"));
        postalCodeField.sendKeys("12345");

        //WebElement countryComboBox = driver.findElement(By.id("uniform-id_country"));

        WebElement homePhoneField = driver.findElement((By.id("phone")));
        homePhoneField.sendKeys("4646464");

        WebElement mobilePhoneField = driver.findElement(By.id("phone_mobile"));
        mobilePhoneField.sendKeys("461616161");

        WebElement addressAliasField = driver.findElement(By.id("alias"));
        addressAliasField.sendKeys("sarasasarasa");

        WebElement submitRegisterAccountButton = driver.findElement(By.id("submitAccount"));
        submitRegisterAccountButton.click();

        Thread.sleep(2000);

        //MyAccountPage
        Assert.assertTrue(driver.findElement(By.className("navigation_page")).getText().equals("My account"), "No se encuentra en la pagina correspondiente mi Cuenta");

        createAccountHeader = driver.findElement(By.className("page-heading"));
        System.out.println(createAccountHeader.getText());
        Assert.assertTrue(createAccountHeader.getText().contains("MY ACCOUNT"), "No se encuentra en la pagina correspondiente mi Cuenta");

        WebElement loggedAccountLabel = driver.findElement(By.className("account"));
        System.out.println(accountNamePerson +" "+ accountLastNamePerson);
        Assert.assertTrue(loggedAccountLabel.getText().contains(accountNamePerson) && loggedAccountLabel.getText().contains(accountLastNamePerson), "No es el usuario loggueado");


    }
}
