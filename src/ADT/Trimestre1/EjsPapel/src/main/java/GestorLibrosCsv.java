import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorLibrosCsv {

    public void guardarLibros(List<LibroCsv> libros, String nombreFichero) {
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get(nombreFichero));

            StatefulBeanToCsv<LibroCsv> escritor =
                    new StatefulBeanToCsvBuilder<LibroCsv>(writer)
                            .withApplyQuotesToAll(false)
                            .build();

            escritor.write(libros);
            System.out.println("Libros guardados.");

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al escribir el CSV: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el writer: " + e.getMessage());
                }
            }
        }
    }

    public List<LibroCsv> leerLibros(String nombreFichero) {
        List<LibroCsv> lista = new ArrayList<>();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(nombreFichero));

            lista = new CsvToBeanBuilder<LibroCsv>(reader)
                    .withType(LibroCsv.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al leer el CSV: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el reader: " + e.getMessage());
                }
            }
        }
        return lista;
    }
}
