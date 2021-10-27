package Clase10.Ejercicio6.Clases;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListeners implements ISuiteListener {

    public void onStart(ISuite suite) {

        System.out.println("Comenzo la ejecución de SuiteListener - OnStart");
    }

    public void onFinish(ISuite suite) {

        System.out.println("Comenzo la ejecución de SuiteListener - OnFinish");
    }
}
