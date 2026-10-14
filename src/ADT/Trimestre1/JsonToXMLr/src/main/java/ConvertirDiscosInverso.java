import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class ConvertirDiscosInverso {
    public static void main(String[] args){
        File ficheroJson = new File("src/ADT/Trimestre1/JsonToXMLr/src/main/java/discos.json");
        File ficheroXMLnuevo = new File("src/ADT/Trimestre1/JsonToXMLr/src/main/java/discosSalida.xml");
        try{
            XmlMapper mapeador = new XmlMapper();
            mapeador.enable(SerializationFeature.INDENT_OUTPUT);
            ObjectMapper mapeadorJson = new ObjectMapper();
            JsonNode arbol = mapeadorJson.readTree(ficheroJson);
            mapeador.writer().withRootName("discos").writeValue(ficheroXMLnuevo, arbol);

            System.out.println("Se ha convertido el archivo JSON a XML.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
