package Clase4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindByNetflix {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://netflix.com");

        PageFactory.initElements(driver, this);

    }
    //Web Elements
    @FindBy (tagName = "p")
    public List<WebElement> listaDeParrafos;

    @FindBy (tagName = "a")
    public List<WebElement> listaDeLinks;

    @FindBy (tagName = "button")
    public List<WebElement> listaDeBotones;

    @FindAll({
            @FindBy (tagName = "h1"),
            @FindBy (tagName = "h2"),
            @FindBy (tagName = "h3")
    })
    public List<WebElement> listadeHs;

    @Test
    public void ejercicio1() {
    //Ejercicios de Parrafos
        Assert.assertTrue(listaDeParrafos.size() != 0, "No existen parrafos");
        System.out.println("La cantidad de parrafos es " + listaDeParrafos.size());

        //Ejercicio de links
        Assert.assertTrue(listaDeLinks.size() != 0, "No existen links");
        System.out.println("La cantidad de links son " + listaDeLinks.size());
        System.out.println("Los links con texto tienen los siguientes textos:");
          for (WebElement eachLink : listaDeLinks){

            if (eachLink.getText().isEmpty() == false){
            System.out.println(eachLink.getText());
            }
    }
    //Ejercicio de botones

        Assert.assertTrue(listaDeBotones.size()!=0,"La lista de botones esta vacia");
        System.out.println("Los botones con texto tienen los siguientes textos");
        for (WebElement eachButton : listaDeBotones) {

            if (eachButton.getText().isEmpty()== false){
            System.out.println(eachButton.getText());
            }
    }

    //Ejercicio de tags H
        Assert.assertTrue(listadeHs.size()!=0, "La lista de H esta vacia");
        System.out.println("Los tags H con texto tiene los siguientes textos");
    for (WebElement eachH : listadeHs){
        if (eachH.getText().isEmpty() == false){
            System.out.println(eachH.getText());
        }

    }

    }

    @AfterMethod
    public void closedDriver() {
        driver.close();
    }




}
