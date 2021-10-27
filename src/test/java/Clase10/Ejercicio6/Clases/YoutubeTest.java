package Clase10.Ejercicio6.Clases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YoutubeTest {

    @BeforeMethod
    public void setup(){
        System.out.println("@BeforeMethod - Setup de YoutubeTest");
    }
    @Test
    public void youtubeTest(){
        System.out.println("Se ejecuta el test youtubeTest");
    }

    @AfterMethod
    public void closeDriver(){
        System.out.println("@AfterMethod - closeDrive de YoutubeTest");
    }
}
