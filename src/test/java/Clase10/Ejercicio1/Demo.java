package Clase10.Ejercicio1;

public class Demo implements MyInterface {

    public static void main (String arg[]){

        Demo obj = new Demo();
        obj.metodoGenerico1();
        obj.metodoGenerico2();
    }

    @Override
    public void metodoGenerico1() {
        System.out.println("Metodo generico 1");

    }

    @Override
    public void metodoGenerico2() {
        System.out.println("Metodo generico 2");

    }

}
