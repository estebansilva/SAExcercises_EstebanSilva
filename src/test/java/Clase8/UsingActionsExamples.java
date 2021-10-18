package Clase8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UsingActionsExamples {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.get("http://automationpractice.com/index.php");
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//li [@class='svelte-vf0pv9'][4]//a")
    public WebElement spotifyRegisterBtn;

    @FindBy (linkText = "Gmail")
    public WebElement gmailLink;

    @FindBy (xpath = "//input [@type = 'email']")
    public WebElement mailTextbox;

    @FindBy (xpath = "/html/body/div")
    public WebElement dobleClickBox;

    @FindBy (id = "draggable")
    public WebElement draggableItembox;

    @FindBy (id = "droppable")
    public WebElement droppableItemBox;



    @Test
    public void registrationSpotifyTest(){
        driver.navigate().to("http://spotify.com");
        Actions action = new Actions(driver);
        action.click(spotifyRegisterBtn)
                .build()
                .perform();
    }

    @Test
    public void gmailExcerciseTest(){
        driver.navigate().to("http://gmail.com");
        Actions action = new Actions(driver);

        //Considerar que el elemento LinkTest no existe en la página. Se deja el textbox mail para probar que el scriptfunciona
        //Moverse hacia el link cuyo LinkTest es Gmail
        action.moveToElement(mailTextbox).build().perform();

        //Hacer doble click sobre el elemento link que llamado Gmail
        action.doubleClick(mailTextbox).build().perform();

        //Hacer click derecho sobre el elemento link que llamado Gmail
        action.contextClick(mailTextbox).build().perform();
    }

    //Hacer consulta por el script de JavaScript
    @Test
    public void testDoubleClick(){

        driver.navigate().to("http://api.jquery.com/dblclick/");
        Actions actions = new Actions (driver);
        driver.switchTo().frame(0);
        posicionarElemento(dobleClickBox);


    }

    @Test
    public void dragAndDrop(){
        driver.navigate().to("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        Actions action = new Actions(driver);

        action.dragAndDrop(draggableItembox, droppableItemBox)
                .build()
                .perform();
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }



    private void posicionarElemento(WebElement elemento){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elemento);
        try {
            Actions action = new Actions(driver).doubleClick(elemento);
            action.build().perform();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
