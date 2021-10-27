package Clase10.Ejercicio5;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(value = InvokedMethodListener.class)

public class ExampleTest {

    @BeforeMethod
    public void setup(){
        System.out.println("Se inicia setup del Before Method de ExampleTest");
    }
    @Test
    public void exampleTest(){
        System.out.println("Se inicia el test exampleTest");
    }

    @AfterMethod
    public void quit(){
        System.out.println("Se inicia quit del After Method de ExampleTest");
    }
}
