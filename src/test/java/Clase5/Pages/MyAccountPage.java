package Clase5.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {

    //Constructor
    public MyAccountPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    //FindBys
    @FindBy(className = "navigation_page")
    public WebElement navigationPanel;

    @FindBy(className = "page-heading")
    public WebElement createAccountHeader;

    @FindBy(xpath = "//a[@title ='Information']")
    public WebElement myPersonalInformationBtn;

    //Methods
    public String getNavigationPanelPosition(){
        System.out.println(navigationPanel.getText());
        return navigationPanel.getText();

    }

    public String getAccountHeader() {
        System.out.println(createAccountHeader.getText());
        return createAccountHeader.getText();
    }

    public MyPersonalInformationPage clickOnMyPersonalInformationButton(){

        myPersonalInformationBtn.click();
        MyPersonalInformationPage myPersonalInformationPage = new MyPersonalInformationPage(driver);
        return myPersonalInformationPage;

    }
}
