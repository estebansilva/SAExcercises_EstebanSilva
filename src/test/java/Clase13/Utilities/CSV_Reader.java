package Clase13.Utilities;

import Clase13.Clases.Persona;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV_Reader {

    public static List<Persona> cargarListaPersonas() throws IOException, CsvValidationException {

        CSVReader reader = new CSVReader(new FileReader("dataloader/personas.csv"));

        String[] arregloPersonas;
        List<Persona> listaPersonas = new ArrayList<>();

        //public static List<Persona> LISTA_PERSONAS = new ArrayList<>();
        while ((arregloPersonas = reader.readNext()) != null){
            for (int i=0; i < arregloPersonas.length; i++){
                //String persona = arregloPersonas[i];
                //System.out.println("Persona: " + persona);

                //Desgloso los datos de una persona
                String[]datosPersona = arregloPersonas[i].split(";"); //laura@example.com;2070;Laura;Grey
                String email = datosPersona[0];
                String identifier = datosPersona[1];
                String firstName = datosPersona[2];
                String lastName = datosPersona[3];

                Persona person = new Persona(email, identifier, firstName, lastName);
                listaPersonas.add(person);
                //System.out.println("Se cargo la persona " + person);

            }
        }
        listaPersonas.remove(0);
        return listaPersonas;

    }

    public static List<Persona> getListaPersonas(List<Persona> listaPersona) throws CsvValidationException, IOException {
        System.out.println("Consulto si la lista esta vacia");
        if (listaPersona.size() == 0){
            System.out.println("Cargo la lista");
            listaPersona= cargarListaPersonas();
        }else {System.out.println("La lista ya estaba cargada");}

        return  listaPersona;
    }
}
