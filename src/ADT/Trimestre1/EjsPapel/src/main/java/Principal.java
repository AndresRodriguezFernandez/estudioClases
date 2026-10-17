import java.util.Arrays;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        GestorLibrosCsv gestor = new GestorLibrosCsv();

        LibroCsv lib1 = new LibroCsv("Don Quejica de la Mancha", "Miguel de Cervatillos", 430, 20.99);
        LibroCsv lib2 = new LibroCsv("101 enanitos", "Anónimo", 70, 9.99);
        LibroCsv lib3 = new LibroCsv("1984", "Jorge Orwell", 324, 12.99);

        String fichero = "src/ADT/Trimestre1/EjsPapel/src/main/java/libros.csv";
        List<LibroCsv> lista = Arrays.asList(lib1, lib2, lib3);

        gestor.guardarLibros(lista, fichero);

        List<LibroCsv> resultado = gestor.leerLibros(fichero);

        for (LibroCsv i : resultado) {
            System.out.println(i.toString());
        }
    }
}
