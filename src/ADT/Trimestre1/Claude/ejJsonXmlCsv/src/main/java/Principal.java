import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.*;

public class Principal {
    public static void main(String[]args){
        File fichero = new File("src/ADT/Trimestre1/Claude/ejJsonXmlCsv/src/main/java/catalogo.json");
        ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();
        videojuegos.add(new Videojuego("GTA VII", "Juegos strella", 2045, 109.99));
        videojuegos.add(new Videojuego("ETS3", "CSC Software", 2030, 25.99));
        videojuegos.add(new Videojuego("EBS", "CSC Software", 2028, 10));
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).enable(SerializationFeature.INDENT_OUTPUT);
        try{

            mapper.writeValue(fichero, videojuegos);
            System.out.println("Lista JSON completada");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        File ficheroXML = new File("src/ADT/Trimestre1/Claude/ejJsonXmlCsv/src/main/java/catalogo.xml");
        XmlMapper xmlMapper = new XmlMapper();
        try{
            JsonNode arbol = mapper.readTree(fichero);
            xmlMapper.writer().withRootName("Videojuego").writeValue(ficheroXML, arbol);
            System.out.println("Conversión a XML realiada");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        File ficheroJson = new File("ficheroXMlJson.json");
        String ficheroCsv = "ficherosCSV.csv";
        try{
            JsonNode arbol2 = xmlMapper.readTree(ficheroXML);
            mapper.writeValue(ficheroJson, arbol2);
            System.out.println("Conversion de XML a Json realiada");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        GestorVideojuegos.guardarCsv(videojuegos, ficheroCsv);
        List<Videojuego> listaF = GestorVideojuegos.leerCsv(ficheroCsv);
        for (Videojuego i : listaF){
            System.out.println(i.toString());
        }
    }
}
