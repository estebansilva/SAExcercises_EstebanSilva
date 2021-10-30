package ExamenSeleniumAcademy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{

    //Constructor
    public LandingPage(WebDriver remoteDriver){super(remoteDriver);}

    //FindyBy
    @FindBy (xpath = "//a [@data-ga-action='premium']")
    public WebElement premiumButton;
    @FindBy (xpath = "//a [@data-ga-action='sign-up']")
    public WebElement registrationButton;


    public PremiumPage clickOnPremiunOption() {
    premiumButton.click();

    PremiumPage premiumPage = new PremiumPage(driver);
    return premiumPage;

    }

    public RegistrationPage clickOnRegistrationButton() {
        registrationButton.click();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage;

    }
}
