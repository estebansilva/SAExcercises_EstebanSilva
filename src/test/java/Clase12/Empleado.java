package Clase12;

public class Empleado {

    String nombre;
    String dni;
    String cargo;

    public Empleado(String elNombre, String elDni, String elCargo){
        this.nombre = elNombre;
        this.dni = elDni;
        this.cargo = elCargo;
    }

    public String getNombre(){ return this.nombre;}
    public String getDni(){return this.dni;}
    public String getCargo(){return this.cargo;}

    public String toString(){
        return (this.nombre + " tiene DNI " + this.dni + " y su cargo es " + this.cargo);
    }
}
