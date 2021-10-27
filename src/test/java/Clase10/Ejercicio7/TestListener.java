package Clase10.Ejercicio7;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    //variable
    Integer contPass = 0;
    Integer contFail = 0;
    Integer contSkip = 0;

    public void onTestStart(ITestResult result) {

        System.out.println("Se ejecuta OnTestStar de ITestListener --- Test-> " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Se ejecuta onTestSuccess de ITestListener --- Test-> " + result.getName());
        contPass ++;
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Se ejecuta onTestFailure de ITestListener --- Test-> " + result.getName());
        contFail ++;
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Se ejecuta onTestSkipped de ITestListener --- Test-> " + result.getName());
        contSkip ++;
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Se ejecuta onTestFailedButWithinSuccessPercentage de ITestListener --- Test-> " + result.getName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Se ejecuta onTestFailedWithTimeout de ITestListener --- Test-> " + result.getName());
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("Se ejecuta onStart de ITestListener --- Suite-> " + context.getName());

    }

    public void onFinish(ITestContext context) {
        System.out.println("Se ejecuta onFinish de ITestListener --- Suite-> " + context.getName());
        System.out.println("Pasaron " + contPass + " casos de prueba");
        System.out.println("Fallaron " + contFail + " casos de prueba");
        System.out.println("Skipearon " + contSkip + " casos de prueba");
    }
}
