package ExamenSeleniumAcademy.Steps;

import ExamenSeleniumAcademy.Pages.LandingPage;
import ExamenSeleniumAcademy.Pages.PremiumPage;
import ExamenSeleniumAcademy.Pages.RegistrationPage;
import ExamenSeleniumAcademy.Pages.UserAgreementPage;
import ExamenSeleniumAcademy.Utilities.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class spotifySteps {

    WebDriver driver;
    LandingPage landingPage;
    PremiumPage premiumPage;
    RegistrationPage registrationPage;
    UserAgreementPage userAgreementPage;

    @Given("estoy en el pantalla de principal")
    public void estoy_en_el_pantalla_de_principal() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spotify.com/uy/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        landingPage = new LandingPage(driver);

    }

    @When("Ingreso a la sección Premium")
    public void ingreso_a_la_sección_premium() {

        premiumPage = landingPage.clickOnPremiunOption();

    }

    @Then("Visualizo los planes")
    public void visualizo_los_planes() {

        Assert.assertTrue(premiumPage.validateExistingPlans("Individual"), Constants.NO_EXISTEN_LOS_PLANES);
        Assert.assertTrue(premiumPage.validateExistingPlans("Duo"), Constants.NO_EXISTEN_LOS_PLANES);
        Assert.assertTrue(premiumPage.validateExistingPlans("Familiar"), Constants.NO_EXISTEN_LOS_PLANES);
    }

    @When("ingreso a la pagina de registro")
    public void ingreso_a_la_pagina_de_registro() {

        registrationPage = landingPage.clickOnRegistrationButton();


    }

    @When("escribo el email {string}")
    public void escribo_el_email(String email) {

        registrationPage.writeEmailSuer(email);


    }

    @Then("visualizo el mensaje de validación {string}")
    public void visualizo_el_mensaje_de_validación(String validation_msg) throws InterruptedException {
        System.out.println("esperado --->" + validation_msg);
        Assert.assertEquals(registrationPage.getValidationMSG(), validation_msg, Constants.VALIDATION_MSG_ERROR);

     }

    @When("ingreso a la pagina de terminos y condiciones")
    public void ingreso_a_la_pagina_de_terminos_y_condiciones() {
        driver.navigate().to("https://www.spotify.com/uy/legal/end-user-agreement/");
        userAgreementPage = new UserAgreementPage(driver);

    }

    @Then("visualizo los links")
    public void visualizo_los_links() {

        Assert.assertTrue(userAgreementPage.existinglinkvalidation("Disfrutando Spotify"),Constants.NO_EXISTE_EL_LINK);
        Assert.assertTrue(userAgreementPage.existinglinkvalidation("Pagos, cancelaciones y periodo de reflexión"),Constants.NO_EXISTE_EL_LINK);
        Assert.assertTrue(userAgreementPage.existinglinkvalidation("Uso de nuestro servicio"),Constants.NO_EXISTE_EL_LINK);

    }

}
