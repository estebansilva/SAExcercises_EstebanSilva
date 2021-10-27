package Clase13.Tests;

import Clase13.Utilities.CSV_Reader;
import Clase13.Pages.RegisterAccountPage;
import Clase13.Clases.Persona;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShopifyTest {

    WebDriver driver;
    public static List<Persona> LISTA_PERSONAS = new ArrayList<>();
    private int contador = 0;

    @BeforeTest
    public void loaderCSV() throws CsvValidationException, IOException {
        System.out.println("Se inicia la carga del CSV");
        LISTA_PERSONAS = CSV_Reader.getListaPersonas(LISTA_PERSONAS);
        System.out.println("Imprimo la lista");
        for (Persona persona : LISTA_PERSONAS){
            System.out.println(persona.getFirstName());
        }
    }

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.shopify.com/signup");

    }

    @Test(invocationCount = 3
    )
    public void spotifyTest() throws InterruptedException {
      System.out.println("Se ejecuta el test");
      RegisterAccountPage registerAccountPage = new RegisterAccountPage(driver);

       registerAccountPage.registerAccount(LISTA_PERSONAS, contador);
       contador++;
       Thread.sleep(5000);
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
