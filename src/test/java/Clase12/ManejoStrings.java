package Clase12;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ManejoStrings {

    @Test
    public void concatStringEj1(){

        String nombre = "Juan";
        String segundoNombre = "Pablo";
        String apellido = "Segundo";

        String fullName = nombre.concat(" ").concat(segundoNombre).concat(" ").concat(apellido);
        System.out.println(fullName);
    }
    
    @Test
    public void endsWithStringEj2(){

        ArrayList<String> emailList = new ArrayList<>();
        emailList.add("email1@email.com");
        emailList.add("email2@email.com");
        emailList.add("email3@email.ar");
        
        for (String email : emailList){
            if(email.endsWith(".com")==false){
                Assert.assertTrue(false, "El mail no termina con .com");
            }
        }
    }

    @Test
    public void includeStringEj3(){

        List<String> emailList = null;
        emailList.add("email1@email.com");
        emailList.add("email2@email.com");
        emailList.add("email3email.ar");

        for (String email : emailList){
            if(email.contains("@")==false){
                Assert.assertTrue(false, "El mail no tiene @");
            }
        }
    }

    @Test
    public void indexOfStringEj4(){

        String email = "email@gmail.com";
        System.out.println(email.indexOf("@"));
    }

    @Test
    public void replaceStringEj5(){
        String email = "email@gmail.com";
        System.out.println(email.replace("@gmail.com","@hotmail.com"));

        String personas = "nombre,apellido,dni;otronombre,otroapellido,otrodni;";
        String personasA = personas.replace(",","-");
        String personasB = personasA.replace(";","@");
        System.out.println(personasB);
    }

    @Test
    public void splitStringEj6(){
        String datosPersona = "33333333,Juan Pablo,Segundo,Argentina";

        String[] arregloPersona = datosPersona.split(",");

        System.out.println(arregloPersona[0]);
        System.out.println(arregloPersona[1]);
        System.out.println(arregloPersona[2]);
        System.out.println(arregloPersona[3]);
    }

    @Test
    public void startWithStringEj7(){

        ArrayList<String> emailList = new ArrayList<>();

        emailList.add("info@email.com");
        emailList.add("email2@email.com");

        for (String email : emailList){
            if(email.startsWith("info")==false){
                Assert.assertTrue(false, "El mail no tiene @");
            }
        }
    }

    @Test
    public void susbstringStringEJ8(){

        String texto = "A existe todo esto B";
        System.out.println(texto.substring(1,19));
    }

    @Test
    public void toLowerCaseAndUpperCaseStringEj9y10(){

        String textovariado = "UN texto con MAYUSCULAS y MINUSCULAS";

        System.out.println(textovariado.toLowerCase());
        System.out.println(textovariado.toUpperCase());

    }
}
