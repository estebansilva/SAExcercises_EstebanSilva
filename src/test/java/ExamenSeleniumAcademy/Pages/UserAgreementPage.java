package ExamenSeleniumAcademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserAgreementPage extends BasePage {

    public UserAgreementPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    @FindBy (tagName = "h1")
    public List<WebElement> allLinks;

    public List<WebElement> aLinks;


    public boolean existinglinkvalidation(String texto_link_spotify) {

        boolean flag = false;
        
        for (WebElement link : allLinks){
            System.out.println(link.findElement(By.tagName("a")).getText());
            if ( link.findElement(By.tagName("a")).getText() == texto_link_spotify){
                flag= true;
            }
            break;

        }

        return flag;
    }
}
