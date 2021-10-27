package Clase13.Clases;

public class Persona {

    String loginEmail;
    String identifier;
    String firstName;
    String lastName;

    public Persona(String loginEmail, String identifier, String firstName, String lastName){
        this.loginEmail = loginEmail;
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLoginEmail(){
        return this.loginEmail;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String toString(){

        return ("Email login: " + this.loginEmail + " Identificador " + this.identifier + " Nombre " + this.firstName + " Apellido " + this.lastName);
    }
}
