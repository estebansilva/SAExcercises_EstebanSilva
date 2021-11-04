package ExamenSeleniumAcademy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PremiumPage extends BasePage {


     //Constructor
    public PremiumPage(WebDriver remoteDriver){super(remoteDriver);}



    @FindBy (xpath = "//h3 [@class='Type__TypeElement-goli3j-0 gSmyKa sc-jfkLlK hiwdBw']")
    public List<WebElement> premiunPlanList;

    public boolean validateExistingPlans(String plan) {
        boolean flag = false;
        for (WebElement element : premiunPlanList){

            if (element.getText().contains(plan)){
                flag = true;
                break;
                }

        }

        return flag;
    }
}
