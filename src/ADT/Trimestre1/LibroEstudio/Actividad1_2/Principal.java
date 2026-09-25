package ADT.Trimestre1.LibroEstudio.Actividad1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws IOException {
        File archivo  = new File(args[0]);
        if (archivo.exists()) {
            try (FileReader fr = new FileReader(archivo)){
                System.out.println("------Visualización en caracteres-------");
                int a;
                while ((a = fr.read()) != -1) {
                    System.out.print((char) a);
                }
                System.out.println();
            }catch (FileNotFoundException e) {
                System.out.println("Error:"+e.getMessage());
            }
            System.out.println("-----Leyendo linea a linea-----");
            List<String> lineas = Files.readAllLines(archivo.toPath());
            for (String i: lineas) {
                System.out.println(i);
            }
        }else {
            System.out.println("El archivo no existe.");
        }
    }
}
