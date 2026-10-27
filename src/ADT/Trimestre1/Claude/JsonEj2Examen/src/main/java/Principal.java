import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

public class Principal {
    public static void main(String[]args) {
        File fichero = new File("coches.json");
        try {
            ArrayList<Coche> coches = new ArrayList<>();
            coches.add(new Coche("6770JSK", "Nissan", "Pulsar", 2017));
            coches.add(new Coche("4088JRX", "Nissan", "Micra", 2017));
            coches.add(new Coche("1234ABC", "Nissan", "Pulsar", 2017));
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).enable(SerializationFeature.INDENT_OUTPUT);//se prepara el objeto que serialiará el json
            mapper.writeValue(fichero, coches); //se escribe el array entero
            System.out.println("Lista inical guardada");
            ArrayList<Coche> cochesLeidos = mapper.readValue(fichero, new TypeReference<ArrayList<Coche>>() {});    //se leen los valores del json y se meten en un array
            for(Coche c :cochesLeidos) {
                System.out.println(c.toString());
            }

        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

