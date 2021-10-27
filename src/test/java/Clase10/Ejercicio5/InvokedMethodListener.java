package Clase10.Ejercicio5;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Se llama a beforeInvocation de InvokedMethodListener en el metodo -->" + method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        System.out.println("Se llama a afterInvocation de InvokedMethodListener en el metodo -->" + method.getTestMethod().getMethodName());
    }


}
