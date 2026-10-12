import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GestorProductos {
    static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).enable(SerializationFeature.INDENT_OUTPUT);
    public static void guardarProductos(List<Producto> productos, String nombreFichero){
        try{
            mapper.writeValue(new File(nombreFichero), productos);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Producto> leerProdcutos(String nombreFichero){
        try{
            List<Producto> productos = mapper.readValue(new File(nombreFichero), new TypeReference<List<Producto>>() {});
            return productos;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void subirPrecio(String nombreFichero, String codigoProducto, double porcentaje) throws IOException {
        JsonNode nodo = mapper.readTree(new File(nombreFichero));
        ArrayNode array = (ArrayNode) nodo;
        for (JsonNode elemento: array){
            ObjectNode obj = (ObjectNode) elemento;
            if (obj.get("codigo").asText().equalsIgnoreCase(codigoProducto)){
                double nuevoPrecio = obj.get("precio").asDouble()*(1+porcentaje/100);
                obj.put("precio", nuevoPrecio);
            }
        }
        mapper.writeValue(new File(nombreFichero), array);
    }
}
