package Clase10.Ejercicio7;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestToUseListener {

    @BeforeMethod
    public void setup(){
        System.out.println("@BeforeMethod ->Inicia el setup de TestToUseListener");

    }

    @Test
    public void sucessTest(){
        System.out.println("@Test ->Inicia el test sucessTest de TestToUseListener");
        Assert.assertEquals(1,1);

    }

    @Test
    public void failureTest(){
        System.out.println("@Test ->Inicia el test failureTest de TestToUseListener");
        Assert.assertEquals(1,3);

    }

    @Test
    public void skippedTest(){
        System.out.println("@Test ->Inicia el test skippedTest de TestToUseListener");
        throw new SkipException("Skipped Test!!");
    }


    @AfterMethod
    public void closeDriver(){
        System.out.println("@AfterMethod el closeDriver de TestToUseListener");

    }
}
