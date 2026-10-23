import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GestorPeliculas {
    static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).enable(SerializationFeature.INDENT_OUTPUT);
    public static void guardarPeliculas(List<Pelicula> lista, String nombreFichero){
        try{
            mapper.writeValue(new File(nombreFichero), lista);
        }catch(StreamWriteException e){
            System.out.println("Error de escritura");
        }catch (DatabindException e) {
            System.out.println("Error: "+e.getMessage());
        }catch (IOException e){
            System.out.println("Error al buscar el fichero");
        }
    }

    public static List<Pelicula> leerProductos(String nombreFichero){
        try{
            List<Pelicula> listaLeida = mapper.readValue(new File(nombreFichero), new TypeReference<List<Pelicula>>(){});
            return listaLeida;
        }catch (JsonMappingException e){
            System.out.println("Error de mapeo JSON");
        }catch (JsonProcessingException e){
            System.out.println("Error de procesado json");
        }catch (IOException e){
            System.out.println("Error de lectura de fichero");
        }
        return List.of();
    }
}
