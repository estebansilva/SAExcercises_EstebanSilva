package Clase12;

public class Persona {

    String dni;
    String nombre;
    String ciudad;
    String pais;
    String email;

    public Persona(String elDni, String elNombre, String laCiudad, String elPaís, String elemail){
        this.dni = elDni;
        this.nombre = elNombre;
        this.ciudad = laCiudad;
        this.pais = elPaís;
        this.email = elemail;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais(){
        return pais;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){

        return ("La persona con nombre " + this.nombre + " Tiene DNI " + this.dni + " es de " + this.ciudad + " , " + this.pais + " y su email es " + this.email);
    }
}
