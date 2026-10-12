package ADT.Trimestre1.Claude.EjObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Libro lib1 = new Libro("Blancanieves y los 101 enanitos", "Pepito", 2002, 10.99);
        Libro lib2 = new Libro("101 enanitos", "Juanito", 2005, 12.99);
        Libro lib3 = new Libro("Caperucita azul", "Joselito", 1999, 9.99);
        Libro lib4 = new Libro("1985", "Jorge Urgado", 1984, 12);

        List<Libro> librosTotal = new ArrayList<>();
        librosTotal.add(lib1);
        librosTotal.add(lib2);
        librosTotal.add(lib3);
        librosTotal.add(lib4);


        String nombreFichero = "src/ADT/Trimestre1/Claude/EjObject/biblioteca.dat";
        GestorBiblioteca.escribirLibros(librosTotal, nombreFichero);
        List<Libro> librosActuales = GestorBiblioteca.leerLibros(nombreFichero);
        for(Libro i: librosActuales){
            System.out.println(i.toString());
        }


        System.out.println("Valor total de la colección: "+GestorBiblioteca.calcularValorTotal(nombreFichero)+"€.");


        System.out.print("Introduce un nombre de autor para comprobar los libros que tenemos de él/ella: ");
        String nombre = sc.nextLine();
        List<Libro> librosAutor = GestorBiblioteca.buscarPorAutor(nombreFichero, nombre);
        System.out.println("Los libros de "+nombre+" son:");
        for(Libro i: librosAutor){
            System.out.println(i.toString());
        }
    }
}
