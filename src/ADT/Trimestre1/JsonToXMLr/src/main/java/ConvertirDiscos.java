import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class ConvertirDiscos {
    public static void main(String[] args){
        File ficheroxml = new File("src/ADT/Trimestre1/JsonToXMLr/src/main/java/discos.xml");
        File ficheroJson = new File("discos.json");
        try{
            XmlMapper mapeadorXML = new XmlMapper();
            JsonNode arbol = mapeadorXML.readTree(ficheroxml);
            ObjectMapper jsonmapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            jsonmapper.writeValue(ficheroJson, arbol);
            System.out.println("Conversión de XML a JSON realizada");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
