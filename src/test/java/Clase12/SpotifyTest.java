package Clase12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyTest {

    WebDriver driver;

    public List<String> emailList = new ArrayList<>();
    public String data = "112111,Emiliano,Montevideo,Uruguay,testing@test.com;12341234, Ana, Buenos Aires, Argentina, ana@ana.com";



    @BeforeTest
    public void loadInformation(){

        List<String> listaDePersonas = Arrays.asList(data.split(";"));
        for (String persona : listaDePersonas) {
            String[] datosPersonales = persona.split(",");
            String email = datosPersonales[4];
            emailList.add(email);
        }
    }


    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://shopify.com/signup");
        PageFactory.initElements(driver, this);

     }


    private int contador = 0;
    @Test(invocationCount = 2)
    public void testSpotify() throws InterruptedException {

        System.out.println("---> " + contador + " el mail a cargar es " + emailList.get(contador));
        //String email = emailList.get(contador);
        driver.findElement(By.id("0_signup_email")).sendKeys(emailList.get(contador));
        Thread.sleep(5000);
        contador++;

    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
