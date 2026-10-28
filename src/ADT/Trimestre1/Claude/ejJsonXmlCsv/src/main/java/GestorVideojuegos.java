import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import  com.opencsv.bean.StatefulBeanToCsv;

public class GestorVideojuegos {
    public static void guardarCsv(List<Videojuego> lista, String fichero){
        try(Writer writer = Files.newBufferedWriter(Paths.get(fichero))){
            StatefulBeanToCsv<Videojuego> escritor = new StatefulBeanToCsvBuilder<Videojuego>(writer).withApplyQuotesToAll(false).build();
            escritor.write(lista);
            System.out.println("Videojuegos guardados en CSV");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Videojuego> leerCsv(String fichero){
        try(Reader reader = Files.newBufferedReader(Paths.get(fichero))){
            List<Videojuego> lista = new CsvToBeanBuilder<Videojuego>(reader).withType(Videojuego.class).build().parse();
            return lista;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
