package Clase12;

import java.util.*;

import org.testng.annotations.Test;


public class ManejoMapas {

    HashMap <String, Empleado> empleadosMap = new HashMap<>();


    @Test
    public void ej1Mapas(){

        HashMap<Integer, String> capitalesMap = new HashMap<>();

        capitalesMap.put(1, "Buenos Aires");
        capitalesMap.put(2, "Montevideo");
        capitalesMap.put(3, "Paris");
        capitalesMap.put(4, "Santiago");
        capitalesMap.put(5, "Tokio");

        for (int i = 0; i < capitalesMap.size(); i++){
            System.out.println("Posición " + i + " Capital " + capitalesMap.get(i + 1) );
        }

        for (Map.Entry capital: capitalesMap.entrySet()){
            System.out.println("ID " + capital.getKey() + " nombre capital " + capital.getValue());
        }

        capitalesMap.put(1, "Madrid");
        capitalesMap.remove(2);

        for (Map.Entry capital: capitalesMap.entrySet()){
            System.out.println("ID " + capital.getKey() + " nombre capital " + capital.getValue());
        }
    }

    @Test
    public void ejEmpleado(){

        String[] empleadoArray = DataHelper.nominaEmpleados.split(";");
        setearDatosEmpleados(empleadoArray);

        System.out.println(":::::::Lista de empleados:::::::");

        //Pq me recupera el toString() el mapa
        //Pq no puedo definir el HashMap dentro de una función.
        for (Empleado empleado : empleadosMap.values()){
        System.out.println(empleado);
        }

        System.out.println("-------------El empleado con DNI seleccionado es " +  empleadosMap.get("25412321"));
    }

    @Test
    public void ejPersonas(){

        List<String> personasList = Arrays.asList(DataHelper.nominaPersonas.split(";"));

        List<String> nombrePersonasList = new ArrayList<>();
        List<String> emailPersonasList = new ArrayList<>();

        nombrePersonasList = obtenerListaDeNombres(personasList);
        System.out.println("::Los nombres son::");
        for (String nombre : nombrePersonasList){
          System.out.println(nombre);
        }
        emailPersonasList = obtenerListaDeemail(personasList);
        System.out.println("::Los emails son::");
        for (String email : emailPersonasList){
            System.out.println(email);
        }

        //Solución usando Arrays
        buscarNombreUsandoArrays(personasList, nombrePersonasList);
        //Solución usando Mapas
        buscarNombreUsandoHashMap(personasList);
    }




    public void setearDatosEmpleados (String[] empleadosArray){

        for (int i = 0; i < empleadosArray.length; i++){
            String[] datosEmpleado = empleadosArray[i].split(",");
            String nombre = datosEmpleado[0];
            String dni = datosEmpleado[1];
            String cargo = datosEmpleado[2];

            Empleado empleados = new Empleado(nombre, dni, cargo);

            empleadosMap.put(empleados.getDni(), empleados);
            System.out.println(":::::::Lista de empleados agregados:::::::");
            System.out.println("Se agrego al empleado " + empleados.toString());

        }
    }

    public List<String> obtenerListaDeNombres(List<String> personasList){
        List<String> listaNombres = new ArrayList<>();

        for (String persona : personasList){
            String[] datosPersona = persona.split(",");
            String nombre = datosPersona[1];
            listaNombres.add(nombre);
        }
        return listaNombres;
    }

    public List<String> obtenerListaDeemail(List<String> personasList){
        List<String> listaEmail = new ArrayList<>();

        for (String persona : personasList){
            String[] datosPersona = persona.split(",");
            String email = datosPersona[4];
            listaEmail.add(email);
        }
        return listaEmail;
    }

    public void buscarNombreUsandoArrays(List<String>personasList, List<String >nombrePersonasList){

        System.out.println(":::Solución usando Arrays:::");
        String[] arreglosDeNombres = new String[nombrePersonasList.size()];
        String[] arregloDePersonas = new String[nombrePersonasList.size()];

        for (int i=0; i< nombrePersonasList.size(); i++){
            arreglosDeNombres[i] = nombrePersonasList.get(i);
            arregloDePersonas[i] = personasList.get(i);
        }

        System.out.println("Ingrese el nombre a buscar");
        /*Scanner input = new Scanner(System.in);
        String nombreABuscar = input.nextLine();*/
        String nombreABuscar= "Ana";
        int posicion = nombrePersonasList.indexOf(nombreABuscar);

        System.out.println("Persona " + nombreABuscar);
        System.out.println(arregloDePersonas[posicion]);
    }

    public void buscarNombreUsandoHashMap(List<String>personasList){
        System.out.println(":::Solución usando Mapas:::");
        HashMap<String,Persona> personasMapa = new HashMap<>();

        for (String persona : personasList){
            String[] datosPersona = persona.split(",");
            String dni = datosPersona[0];
            String nombre = datosPersona[1];
            String ciudad = datosPersona[2];
            String pais = datosPersona[3];
            String email = datosPersona[4];

            Persona person = new Persona(dni, nombre, ciudad, pais, email);

            personasMapa.put(person.getNombre(), person);
            System.out.println(":::::::Lista de empleados agregados:::::::");
            System.out.println("Se agrego la persona " + persona.toString());
        }

        System.out.println("Ingrese el nombre a buscar");
        /*Scanner input = new Scanner(System.in);
        String nombreABuscar = input.nextLine();*/
        String nombreABuscar= "Ana";


        System.out.println("Persona " + nombreABuscar);
        System.out.println(personasMapa.get(nombreABuscar));

    }
}
