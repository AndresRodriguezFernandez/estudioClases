import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Principal {
    public static void main(String[]args){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Pelicula("BlancaTormetas y los 10 gigantes", "Yo", 2003, 104));
        listaPeliculas.add(new Pelicula("Despacio y de chill", "K.J", 2000, 120));
        listaPeliculas.add(new Pelicula("Parque doméstico", "Yo", 20010, 109));

        GestorPeliculas.guardarPeliculas(listaPeliculas, "src/ADT/Trimestre1/Claude/ExamenVariante1/PersistenciaJson/src/main/java/catalogo.json");

        List<Pelicula> listaLeida =  GestorPeliculas.leerProductos("src/ADT/Trimestre1/Claude/ExamenVariante1/PersistenciaJson/src/main/java/catalogo.json");
        for (Pelicula i: listaLeida){
            System.out.println(i.toString());
        }
    }
}
