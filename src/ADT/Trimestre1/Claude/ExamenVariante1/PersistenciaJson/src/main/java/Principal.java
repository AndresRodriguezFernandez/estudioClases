import java.util.*;

public class Principal {
    public static void main(String[]args){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Pelicula("BlancaTormentas y los 10 gigantes", "Yo", 2003, 104));
        listaPeliculas.add(new Pelicula("Despacio y de chill", "K.J", 2000, 120));
        listaPeliculas.add(new Pelicula("Parque doméstico", "Yo", 2010, 109));

        GestorPeliculas.guardarPeliculas(listaPeliculas, "src/ADT/Trimestre1/Claude/ExamenVariante1/PersistenciaJson/src/main/java/catalogo.json");

        List<Pelicula> listaLeida =  GestorPeliculas.leerProductos("src/ADT/Trimestre1/Claude/ExamenVariante1/PersistenciaJson/src/main/java/catalogo.json");
        Pelicula menor = null;

        for(int i = 0; i < listaLeida.size(); i++) {
            if (listaLeida.get(i+1).getAnio() < listaLeida.get(i).getAnio()){
                menor = listaLeida.get(i);
            }
        }
    }
}
