package Clase10.Ejercicio6.Clases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NetflixTest {

    @BeforeMethod
    public void setup(){
        System.out.println("@BeforeMethod - Setup de NetflixTest");
    }

    @Test
    public void netflixTest(){
        System.out.println("Se inicia el Test netflixTest");
    }

    @Test
    public void otroNetflixTest(){
        System.out.println("Se inicia el Test otroNetflixTest");
    }

    @AfterMethod
    public void closeDriver(){
        System.out.println("@AfterMethod - closeDriver de NetflixTest");
    }
}
