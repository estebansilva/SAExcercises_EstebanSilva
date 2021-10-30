package ExamenSeleniumAcademy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    //Constructor
    public RegistrationPage(WebDriver remoteDriver){super(remoteDriver);}

    //FindBy
    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(xpath = "//div [@aria-label='Indicador de error']")
    public WebElement emailErrorMsg;

    @FindBy(id = "confirm")
    public WebElement confirmEmailField;


    public void writeEmailSuer(String email) {

        emailField.sendKeys(email);
    }



    public String getValidationMSG() throws InterruptedException {
        confirmEmailField.click();
        Thread.sleep(2000);
        String errorMsg = emailErrorMsg.getText();
        System.out.println("Msj de error obtenido---->" + emailErrorMsg.getText());
        return errorMsg;

    }
}
