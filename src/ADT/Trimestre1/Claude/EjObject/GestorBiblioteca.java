package ADT.Trimestre1.Claude.EjObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    public GestorBiblioteca(){}

    public static void escribirLibros(List<Libro> libros, String nombreFichero){
        try(FileOutputStream foos = new FileOutputStream(nombreFichero);
            ObjectOutputStream oos = new ObjectOutputStream(foos)) {
            for(Libro i: libros){
                oos.writeObject(i);
            }
        }catch(IOException e){
            System.out.println("Error de entrada/salida "+e.getMessage());
        }
    }

    public static List<Libro> leerLibros(String nombreFichero){
        List<Libro> librosLista = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(nombreFichero);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            while(true){
                Libro lib = (Libro) ois.readObject();
                librosLista.add(lib);
            }
        }catch(EOFException e) {
        }catch(IOException e){
            System.out.println("Error de entrada/salida: "+e.getMessage());
        } catch(ClassNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
        return librosLista;
    }

    public static double calcularValorTotal(String nombreFichero){
        List<Libro> lista = leerLibros(nombreFichero);
        double precioTotal = 0;
        for(Libro i: lista){
            precioTotal = precioTotal + i.getPrecio();
        }
        return precioTotal;
    }

    public static List<Libro> buscarPorAutor(String nombreFichero, String autor){
        List<Libro> libros = leerLibros(nombreFichero);
        List<Libro> librosAutor = new ArrayList<>();
        for(Libro i : libros){
            if(i.getAutor().equalsIgnoreCase(autor)) {
                librosAutor.add(i);
            }
        }
        return librosAutor;
    }
}
